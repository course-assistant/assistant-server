package cn.hncj.assistant.controller;

import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@CrossOrigin
public class TestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    public ServerResponse<Object> hello(@RequestParam("ids") Integer[] ids) {

        System.out.println(Arrays.toString(ids));

        return ServerResponse.createSuccess("测试成功");
    }


}
