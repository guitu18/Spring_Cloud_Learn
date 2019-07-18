package eureka.consumer.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 夜月归途
 * @date 2019/3/15 17:43
 */
@EnableEurekaClient
@SpringBootApplication
public class RibbonApplication {

    /**
     * 此处添加了一个@LoadBalanced注解，在这里Spring Cloud Ribbon有一个拦截器
     * 它能够在这里进行实际调用的时候，自动的去选取服务实例
     * 并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class);

    }

}
