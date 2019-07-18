package hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 添加 @EnableHystrixDashboard，启用Hystrix Dashboard功能，访问项目路径 + /hystrix
 *
 * @author 夜月归途
 * @date 2019/3/16 12:23
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class HystrixDashboardApplication {


    /**
     * 默认的集群监控：通过URL http://turbine-hostname:port/turbine.stream 开启，实现对默认集群的监控。
     * 指定的集群监控：通过URL http://turbine-hostname:port/turbine.stream?cluster=[clusterName] 开启，实现对clusterName集群的监控。
     * 单体应用的监控：通过URL http://hystrix-app:port/hystrix.stream 开启，实现对具体某个服务实例的监控。
     * 前两者都对集群的监控，需要整合Turbine才能实现
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class);
    }

}
