package cn.hncj.assistant.controller;

import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.constance.ResponseCode;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.LoginService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@RestController
public class LoginController {

    final static Logger logger = LoggerFactory.getLogger(LoginController.class);


    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/login")
    public ServerResponse<Object> login(String username, String password, @RequestParam("type") Short type) {
        if (type < 1 || type > 3) {
            throw new ServerException("type 只能为 1 2 3");
        }
        logger.info("username：" + username);
        logger.info("password：" + password);
        logger.info("type：" + type);
        Map<String, Object> verification;
        // 验证对应的授权
        switch (type) {
            // 学生登录
            case 3:
                verification = loginService.verifyStudentAndIssueToken(username, password);
                break;
            // 教师登录
            case 2:
                verification = loginService.verifyTeacherAndIssueToken(username, password);
                break;
            // 管理员登录
            default:
                verification = loginService.verifyAdministratorAndIssueToken(username, password);
                break;
        }
        // 验证成功
        if ((Boolean) verification.get("authorized")) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", username);
            data.put("type", type);
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
