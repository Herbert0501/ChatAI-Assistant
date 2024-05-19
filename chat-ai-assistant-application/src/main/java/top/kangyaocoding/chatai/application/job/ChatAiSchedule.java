package top.kangyaocoding.chatai.application.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import top.kangyaocoding.chatai.domain.ai.IOpenAi;
import top.kangyaocoding.chatai.domain.zsxq.IZsxqApi;
import top.kangyaocoding.chatai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import top.kangyaocoding.chatai.domain.zsxq.model.vo.Topics;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

/**
 * @Author K·Herbert
 * @Description AI定时工作
 * @Date 2024-05-19 14:49
 */
@EnableScheduling
@Configuration
public class ChatAiSchedule {
    private final Logger logger = LoggerFactory.getLogger(ChatAiSchedule.class);
    @Value("${top-kangyaocoding-ai.groupId}")
    private String groupId;
    @Value("${top-kangyaocoding-ai.cookie}")
    private String cookie;
    @Autowired
    private IZsxqApi zsxqApi;
    @Autowired
    private IOpenAi openAi;

    // 部署5分钟回答一次
    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() throws IOException {
        // 设置一个随机布尔值,防止机器人监测
        if (new Random().nextBoolean()) {
            logger.info("随机打样...");
            return;
        }
        // 获取系统时间,如果时间是晚上23点到早上7点也打样
        int hour = LocalTime.now().getHour();
        if (hour >= 23 || hour <= 7) {
            logger.info("太晚了, 已经打样了...");
            return;
        }
        // 获取待回答消息
        UnAnsweredQuestionsAggregates unAnsweredQuestionsTopicId = zsxqApi.getUnAnsweredQuestionsTopicId(groupId, cookie);
        List<Topics> topics = unAnsweredQuestionsTopicId.getResp_data().getTopics();
        if (topics.isEmpty()) {
            logger.info("没有未回答的问题");
            return;
        }
        // 获取未回答的问题
        String question = topics.get(0).getQuestion().getText();
        // 调用AI接口
        String answer = openAi.getDashScopeAnswer(question + "+字数限制大于10小于550");
        // 回答问题
        zsxqApi.answerQuestion(groupId, cookie, topics.get(0).getTopic_id(), answer, false);
        // 打印日志
        logger.info("回答问题: " + question + " 答案: " + answer);
    }
}

