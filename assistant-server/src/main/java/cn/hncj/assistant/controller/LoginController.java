package cn.hncj.assistant.controller;

import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.pojo.Administrator;
import cn.hncj.assistant.service.AdministratorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
@RestController
public class LoginController {

    private AdministratorService administratorService;

    @Autowired
    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping("/login")
    public ServerResponse<Object> login(
            String administrator_id,
            String administrator_password,
            Short type) {
        ServerResponse<Object> response = null;

        switch (type) {
            case 3:
//                break;
            case 2:
//                break;
            default:
                Administrator administrator = administratorService.findAdministratorByLogin(administrator_id, administrator_password);
                if (administrator == null) {
                    response = ServerResponse.createError("用户名或密码错误");
                } else {
                    response = ServerResponse.createSuccess("登录成功", administrator);
                }
                break;
        }
        return response;
    }

    @Test
    public void test() {
        Administrator administrator = administratorService.findAdministratorByLogin("root", "E10ADC3949BA59ABBE56E057F20F883E");
    }

}
