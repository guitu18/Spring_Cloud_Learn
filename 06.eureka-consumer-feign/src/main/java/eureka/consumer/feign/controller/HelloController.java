package eureka.consumer.feign.controller;

import eureka.consumer.feign.entity.User;
import eureka.consumer.feign.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 夜月归途
 * @date 2019/3/15 18:15
 */
@RestController
public class HelloController {


    @Autowired
    private UserClient userClient;

    @RequestMapping({"", "server"})
    public String server() {
        String server = userClient.server();
        return server;
    }

    @RequestMapping("getUser")
    public User getUser() {
        User user = userClient.getUser();
        return user;
    }

    @RequestMapping("getUserByName")
    public User getUserByName() {
        User user = userClient.getUserByName("guitu18");
        return user;
    }

}
