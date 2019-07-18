package springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.User;

/**
 * @author 夜月归途
 * @date 2019/3/15 20:59
 */
@RestController
public class UserController {

    @RequestMapping("getUser")
    public User getUser() {
        return new User("zhangkuan", "guitu18.com");
    }
}
