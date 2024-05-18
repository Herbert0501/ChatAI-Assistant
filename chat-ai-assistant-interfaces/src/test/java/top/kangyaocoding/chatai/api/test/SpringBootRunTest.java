package top.kangyaocoding.chatai.api.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyaocoding.chatai.domain.ai.IOpenAi;
import top.kangyaocoding.chatai.domain.zsxq.IZsxqApi;
import top.kangyaocoding.chatai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import top.kangyaocoding.chatai.domain.zsxq.model.vo.Topics;

import java.io.IOException;
import java.util.List;

/**
 * @Author K·Herbert
 * @Description
 * @Date 2024-05-18 16:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringBootRunTest {
    private final Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);
    @Value("${top-kangyaocoding-ai.groupId}")
    private String groupId;
    @Value("${top-kangyaocoding-ai.cookie}")
    private String cookie;

    @Autowired
    private IZsxqApi zsxqApi;

    @Autowired
    private IOpenAi  openAi;

    @Test
    public void test_getUnAnsweredQuestionsTopicId() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsTopicId = zsxqApi.getUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("test: {}", unAnsweredQuestionsTopicId);
    }

    @Test
    public void test_answeredQuestion() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsTopicId = zsxqApi.getUnAnsweredQuestionsTopicId(groupId, cookie);

        List<Topics> topics = unAnsweredQuestionsTopicId.getResp_data().getTopics();
        if (topics.isEmpty()) {
            logger.info("没有未回答的问题");
            return;
        }
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String answer = topic.getQuestion().getText();
            logger.info("topicId: {}, answer: {}", topicId, answer);

            zsxqApi.answerQuestion(groupId, cookie,topicId, "我不会", false);
        }
    }

    @Test
    public void chatAi_test() throws IOException {
        String dashScopeAnswer = openAi.getDashScopeAnswer("你是谁？");
        logger.info("dashScopeAnswer: {}", dashScopeAnswer);
    }
}
