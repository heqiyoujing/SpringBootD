package spring.boot.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.boot.com.dao.UserRepositoty;
import spring.boot.com.entity.User;
import spring.boot.com.util.http.HttpUtil;

import java.io.IOException;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2018/8/8
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    private UserRepositoty userRepositoty;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @RequestMapping(value = "/show",method = RequestMethod.POST)
    public String show(@RequestParam(value = "name")String name){
        User user = userRepositoty.findByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getRole();
        else
            return "null";
    }


    @RequestMapping(value = "/showPost")
    public String showPost(@RequestBody String name) throws IOException {
        Map<String, Object> map = HttpUtil.json2Map(name);
        return String.valueOf(map.get("name"));
    }


}
