package top.kangyaocoding.chatai.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author K·Herbert
 * @Description 单元测试
 * @Date 2024-05-17 17:24
 */

public class ApiTest {
    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/15555422882442/topics?scope=unanswered_questions&count=20");

        httpGet.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818842252825882%22%2C%22first_id%22%3A%2218d44927af62b2-052f7a46a7938f4-3d665417-1821369-18d44927af7a2b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkNDQ5MjdhZjYyYjItMDUyZjdhNDZhNzkzOGY0LTNkNjY1NDE3LTE4MjEzNjktMThkNDQ5MjdhZjdhMmIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTg4NDIyNTI4MjU4ODIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818842252825882%22%7D%2C%22%24device_id%22%3A%2218d44927af62b2-052f7a46a7938f4-3d665417-1821369-18d44927af7a2b%22%7D; zsxqsessionid=38ff37f127d2ffbafac6c3a387f5d1cd; zsxq_access_token=2741CC86-42C7-7B7D-3C66-4625D98DB2EB_E9A1BCAA2F4B039D; tfstk=fIinc2gsb2zIj56JtcqBbYz1Gx8OI6Z7BbI8wuFy75P19_HPy7Wre5nL9vEUE_lxw8PEJYelqvN1vWh8p8-o_fdQ22FLUf2uLw7UzgSNb-w8UJzzzOraAc3d2WdQqYlYqIdvDnHIdzZyMIdUicsU0JyPY_eUb5-djsjkDnHILBt5D8xvFlavV7Nz4yzPbGP_E75rayWa75w7U6yPYdDa18rzUWSF_GyYnaSFYU6NPScIMcJxt6AyVR5kbJa3gA8fYMf0UsFsL5jP45N3-ZkUsgSrbVge-UVelOF7vWG_KbtfAkzo8X2aq3jaxXME4PmJ6nUn38l7vcJP8SuK9bzo5IjYKk3goD0BF1kEMW04AYBD9A4mSrwa7TbUvqHxVroexsNTl8c0nXfh4LQNuFS5VRJ-ba_78RwgGoxVbzTl6vr6IdbXbyy_dhvMIa_78RwgMdvGlZzUCJtG.; abtest_env=product");
        httpGet.addHeader("Content-Type", "application/json;charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String s = EntityUtils.toString(response.getEntity());
            System.out.println("成功：" + s);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void send_answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/2855218851181281/answer");

        httpPost.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818842252825882%22%2C%22first_id%22%3A%2218d44927af62b2-052f7a46a7938f4-3d665417-1821369-18d44927af7a2b%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkNDQ5MjdhZjYyYjItMDUyZjdhNDZhNzkzOGY0LTNkNjY1NDE3LTE4MjEzNjktMThkNDQ5MjdhZjdhMmIiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4MTg4NDIyNTI4MjU4ODIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818842252825882%22%7D%2C%22%24device_id%22%3A%2218d44927af62b2-052f7a46a7938f4-3d665417-1821369-18d44927af7a2b%22%7D; zsxqsessionid=38ff37f127d2ffbafac6c3a387f5d1cd; zsxq_access_token=2741CC86-42C7-7B7D-3C66-4625D98DB2EB_E9A1BCAA2F4B039D; tfstk=fIinc2gsb2zIj56JtcqBbYz1Gx8OI6Z7BbI8wuFy75P19_HPy7Wre5nL9vEUE_lxw8PEJYelqvN1vWh8p8-o_fdQ22FLUf2uLw7UzgSNb-w8UJzzzOraAc3d2WdQqYlYqIdvDnHIdzZyMIdUicsU0JyPY_eUb5-djsjkDnHILBt5D8xvFlavV7Nz4yzPbGP_E75rayWa75w7U6yPYdDa18rzUWSF_GyYnaSFYU6NPScIMcJxt6AyVR5kbJa3gA8fYMf0UsFsL5jP45N3-ZkUsgSrbVge-UVelOF7vWG_KbtfAkzo8X2aq3jaxXME4PmJ6nUn38l7vcJP8SuK9bzo5IjYKk3goD0BF1kEMW04AYBD9A4mSrwa7TbUvqHxVroexsNTl8c0nXfh4LQNuFS5VRJ-ba_78RwgGoxVbzTl6vr6IdbXbyy_dhvMIa_78RwgMdvGlZzUCJtG.; abtest_env=product");
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");

        String paramJson = "{\"req_data\":{\"text\":\"等下告诉你\\n\",\"image_ids\":[],\"silenced\":false}}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String s = EntityUtils.toString(response.getEntity());
            System.out.println("成功：" + s);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}