package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import springboot.filter.AccessFilter;

/**
 * @author 夜月归途
 * @date 2019/3/15 17:43
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {


    /**
     * 配置拦截器，注册到SpringBean
     *
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }

}
