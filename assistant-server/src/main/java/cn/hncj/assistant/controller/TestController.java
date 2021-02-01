package cn.hncj.assistant.controller;

import cn.hncj.assistant.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public ServerResponse<Object> hello() {

        return ServerResponse.createSuccess("测试成功", new String[]{"aaa", "bbb", "cc"});
    }

}
