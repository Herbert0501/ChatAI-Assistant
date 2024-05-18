package top.kangyaocoding.chatai.domain.ai.service;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.kangyaocoding.chatai.domain.ai.IOpenAi;
import top.kangyaocoding.chatai.domain.ai.model.aggregates.AIAnswer;
import top.kangyaocoding.chatai.domain.ai.model.vo.Choices;

import java.io.IOException;
import java.util.List;

/**
 * @Author K·Herbert
 * @Description DashScope实现
 * @Date 2024-05-18 22:32
 */
@Service
public class OpenAi implements IOpenAi {
    private final Logger log = LoggerFactory.getLogger(OpenAi.class);
    @Override
    public String getDashScopeAnswer(String question) throws IOException {
        // 创建HttpClient
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 设置POST请求URL
        HttpPost httpPost = new HttpPost("https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation");

        // 获取API Key
        String apiKey = System.getenv("DASHSCOPE_KEY_ID");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key is missing or empty");
        }

        // 设置请求头
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.addHeader("Authorization", "Bearer " + apiKey);

        // 使用String.format生成JSON请求体
        String paramJson = String.format(
                "{\"model\": \"qwen-turbo\", \"input\": {\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"%s\"}]}, \"parameters\": {\"result_format\": \"message\"}}",
                question
        );

        // 将JSON请求体设置为StringEntity
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);

        // 执行请求并获取响应
        CloseableHttpResponse response = httpClient.execute(httpPost);

        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
            AIAnswer aiAnswer = JSON.parseObject(responseString, AIAnswer.class);
            StringBuilder stringBuilder = new StringBuilder();
            List<Choices> choices = aiAnswer.getOutput().getChoices();
            for (Choices choice : choices) {
                stringBuilder.append(choice.getMessage().getContent());
            }
            log.info("成功获取AI回答：" + responseString);
            return stringBuilder.toString();
        } else {
            throw new IOException("请求失败：" + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
        }
    }
}
