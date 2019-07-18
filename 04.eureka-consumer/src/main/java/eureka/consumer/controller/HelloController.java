package eureka.consumer.controller;

import eureka.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
     * 通过loadBalancerClient的choose可以根据名称获取一个eureka-client的服务实例
     */
    @Autowired
    LoadBalancerClient loadBalancerClient;
    /**
     * RestTemplate是Spring提供的用于访问Rest服务的客户端，用户发送请求，非常强大
     */
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping({"", "server"})
    public String server() {
        //通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        // 获取客户端host和port拼接服务地址
        String url = "http://" + host + ":" + port + "/server";
        System.out.println("================" + url + "===================");
        // 发送请求
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println("================" + forObject + "===================");
        return forObject + " -----port: " + port;
    }

    @RequestMapping("getUser")
    public User getUser() {
        //通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        // 获取客户端host和port拼接服务地址
        String url = "http://" + host + ":" + port + "/getUser";
        System.out.println("================" + url + "===================");
        // 发送请求
        User user = restTemplate.getForObject(url, User.class);
        System.out.println("================" + user + "===================");
        return user;
    }

}
