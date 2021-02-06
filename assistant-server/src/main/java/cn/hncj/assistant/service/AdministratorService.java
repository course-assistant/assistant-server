package cn.hncj.assistant.service;

import cn.hncj.assistant.pojo.Administrator;
import org.springframework.stereotype.Service;

public interface AdministratorService {

    public Administrator findAdministratorByLogin(
            String administrator_id,
            String administrator_password
    );
}
