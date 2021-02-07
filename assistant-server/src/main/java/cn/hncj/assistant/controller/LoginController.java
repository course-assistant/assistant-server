package cn.hncj.assistant.controller;

import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("DuplicatedCode")
@SpringBootTest
@RestController
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class LoginController {

    LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/admin")
    public ServerResponse<Object> adminLogin(String username, String password) {
        // 验证登录
        Map<String, Object> verification = loginService.verifyAdministratorAndIssueToken(username, password);
        // 验证成功
        if ((Boolean) verification.get("result")) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", verification.get("token"));
            return ServerResponse.createSuccess("登录成功", data);
        }
        // 验证失败
        return ServerResponse.createError("用户名或密码不正确！");
    }

    @PostMapping("/teacher")
    public ServerResponse<Object> teacherLogin(String username, String password) {
        // 验证登录
        Map<String, Object> verification = loginService.verifyTeacherAndIssueToken(username, password);
        // 验证成功
        if (((Boolean) verification.get("result"))) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", verification.get("token"));
            return ServerResponse.createSuccess("登录成功", data);
        }
        // 验证失败
        return ServerResponse.createError("用户名或密码不正确！");
    }

    @PostMapping("/student")
    public ServerResponse<Object> studentLogin(String username, String password) {
        // 验证登录
        Map<String, Object> verification = loginService.verifyStudentAndIssueToken(username, password);
        // 验证成功
        if (((Boolean) verification.get("result"))) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", verification.get("token"));
            return ServerResponse.createSuccess("登录成功", data);
        }
        // 验证失败
        return ServerResponse.createError("用户名或密码不正确！");
    }

    @Test
    public void test() {

    }

}
