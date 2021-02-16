package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.LoginService;
import cn.hncj.assistant.util.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@RestController
public class LoginController {

    final static Logger log = LoggerFactory.getLogger(LoginController.class);


    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    @CrossOrigin
    @PostMapping("/login")
    public ServerResponse<Object> login(String username, String password, @RequestParam("type") Short type) {
        if (type < 1 || type > 3) {
            throw new ServerException("type 只能为 1 2 3");
        }
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


    @CrossOrigin
    @PostMapping("/authentication")
    public ServerResponse<Object> tokenAuthentication(@RequestParam("token") String token, @RequestParam("type") Short type) {
        if (type < 1 || type > 3) {
            throw new ServerException("type 只能为 1 2 3");
        }
        try {
            DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
            String role = decodedJWT.getClaim("role").asString();
            switch (type) {
                // 学生
                case 3:
                    if (RoleCheck.STUDENT.equals(role)) {
                        return ServerResponse.createSuccess("验证成功");
                    }
                    // 教师
                case 2:
                    if (RoleCheck.TEACHER.equals(role)) {
                        return ServerResponse.createSuccess("验证成功");
                    }
                    // 管理员
                default:
                    if (RoleCheck.ADMIN.equals(role)) {
                        return ServerResponse.createSuccess("验证成功");
                    }
            }
            return ServerResponse.createError("权限验证失败");
        } catch (Exception e) {
            return ServerResponse.createError("权限验证失败");
        }
    }

    @Test
    public void test() {

    }

}
