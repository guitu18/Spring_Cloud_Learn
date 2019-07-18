package eureka.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 添加@EnableFeignClients注解，开启扫描Spring Cloud Feign客户端的功能
 * @author 夜月归途
 * @date 2019/3/15 17:43
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class);

    }

}
