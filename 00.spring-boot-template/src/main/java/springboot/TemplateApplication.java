package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 夜月归途
 * @date 2019/3/15 17:43
 */
@EnableEurekaClient
@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class);

    }

}
