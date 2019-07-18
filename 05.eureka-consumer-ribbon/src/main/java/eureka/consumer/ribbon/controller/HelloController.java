package eureka.consumer.ribbon.controller;

import eureka.consumer.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 夜月归途
 * @date 2019/3/15 18:15
 */
@RestController
public class HelloController {

    /**
     * 这里去掉了LoadBalancerClient的注入，对于RestTemplate的使用，我们也可以去掉host和port了
     * 在这里Spring Cloud Ribbon有一个拦截器
     * 它能够在这里进行实际调用的时候，自动的去选取服务实例
     * 并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用
     */
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping({"", "server"})
    public String server() {
        String forObject = restTemplate.getForObject("http://eureka-client/server", String.class);
        return forObject;
    }

    @RequestMapping("getUser")
    public User getUser() {
        User user = restTemplate.getForObject("http://eureka-client/getUser", User.class);
        return user;
    }

}
