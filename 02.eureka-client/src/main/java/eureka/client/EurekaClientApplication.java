package eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * EurekaClient同理，添加@EnableEurekaClient注解，结合配置文件，就可以像Eureka注册自己的服务
 *
 * @author 夜月归途
 * spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等）
 * @EnableDiscoveryClient 基于spring-cloud-commons,
 * @EnableEurekaClient 基于spring-cloud-netflix。
 * 其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient
 * 如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient。
 * @date 2019/3/15 17:43
 */
//@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class);
    }

}
