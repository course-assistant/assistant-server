package cn.hncj.assistant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @RequestMapping("/test")
    public Object hello() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "测试成功");
        map.put("data", new String[]{"aaa", "bbb", "ccc"});
        return map;
    }

}
