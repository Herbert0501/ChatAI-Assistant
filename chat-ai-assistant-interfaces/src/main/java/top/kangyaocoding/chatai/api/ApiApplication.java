package top.kangyaocoding.chatai.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author K·Herbert
 * @Description 启动入口
 * @Date 2024-05-17 17:10
 */
@SpringBootApplication
@ComponentScan("top.kangyaocoding.chatai.domain")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
