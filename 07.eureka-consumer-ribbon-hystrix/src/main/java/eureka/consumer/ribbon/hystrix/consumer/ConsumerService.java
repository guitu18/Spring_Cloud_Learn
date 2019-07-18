package eureka.consumer.ribbon.hystrix.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eureka.consumer.ribbon.hystrix.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author 夜月归途
 * @date 2019/3/16 11:11
 */
@Component
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "serverFallback")
    public String server() {
        String forObject = restTemplate.getForObject("http://eureka-client/server", String.class);
        return forObject;
    }

    public String serverFallback() {
        return "serverFallback";
    }

    @HystrixCommand(fallbackMethod = "userFallback")
    public User getUser() {
        User user = restTemplate.getForObject("http://eureka-client/getUser", User.class);
        return user;
    }

    public User userFallback() {
        return new User();
    }
}
