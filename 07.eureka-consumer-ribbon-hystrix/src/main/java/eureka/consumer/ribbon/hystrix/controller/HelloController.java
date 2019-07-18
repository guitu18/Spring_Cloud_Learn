package eureka.consumer.ribbon.hystrix.controller;

import eureka.consumer.ribbon.hystrix.consumer.ConsumerService;
import eureka.consumer.ribbon.hystrix.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夜月归途
 * @date 2019/3/15 18:15
 */
@RestController
public class HelloController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping({"", "server"})
    public String server() {
        String server = consumerService.server();
        return server;
    }

    @GetMapping("getUser")
    public User getUser() {
        User user = consumerService.getUser();
        return user;
    }

}
