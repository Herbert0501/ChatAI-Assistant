package top.kangyaocoding.chatai.domain.zsxq;

import top.kangyaocoding.chatai.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @Author K·Herbert
 * @Description 知识星球问答Api
 * @Date 2024-05-18 16:12
 */

public interface IZsxqApi {
    UnAnsweredQuestionsAggregates getUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answerQuestion(String groupId, String cookie, String topicId, String answer, boolean silenced) throws IOException;
}
