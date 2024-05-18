package top.kangyaocoding.chatai.domain.ai;

import java.io.IOException;

/**
 * @Author K·Herbert
 * @Description DashScope接口
 * @Date 2024-05-18 22:32
 */

public interface IOpenAi {
    String getDashScopeAnswer(String question) throws IOException;
}
