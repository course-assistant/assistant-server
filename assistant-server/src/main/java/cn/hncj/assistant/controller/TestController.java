package cn.hncj.assistant.controller;

import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    public ServerResponse<Object> hello() {

        return ServerResponse.createSuccess("测试成功", userMapper.getUsers());
    }

}
