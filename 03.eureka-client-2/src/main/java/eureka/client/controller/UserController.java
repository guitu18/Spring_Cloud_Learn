package eureka.client.controller;

import eureka.client.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 夜月归途
 * @date 2019/3/15 20:59
 */
@RestController
public class UserController {

    /**
     * 注入DiscoveryClient，通过该对象我们能获得注册到Eureka的所有的服务列表
     */
    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    HttpServletRequest request;

    @ModelAttribute
    public void before() {
        System.out.println("=================getRequestURL: " + request.getRequestURL() + "==================");
        System.out.println("=================getRequestURI: " + request.getRequestURI() + "==================");
    }

    @RequestMapping({"", "server"})
    public String server() throws InterruptedException {
//        Thread.sleep(5000L);
        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        return services.toString() + " ------- eureka-client-2";
    }

    @RequestMapping("getUser")
    public User getUser() throws InterruptedException {
//        Thread.sleep(5000L);
        return new User("zhangkuan---eureka-client-2", "guitu18.com");
    }

    @RequestMapping("getUserByName")
    public User getUserByName(String username) {
        return new User(username, null);
    }
}
