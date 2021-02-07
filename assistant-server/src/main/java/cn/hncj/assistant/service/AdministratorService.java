package cn.hncj.assistant.service;

import cn.hncj.assistant.pojo.Administrator;

public interface AdministratorService {

     Administrator findAdministratorByLogin(
             String administrator_id,
             String administrator_password
     );
}
