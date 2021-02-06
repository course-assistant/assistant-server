package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.mapper.AdministratorMapper;
import cn.hncj.assistant.pojo.Administrator;
import cn.hncj.assistant.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorMapper administratorMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @Override
    public Administrator findAdministratorByLogin(String administrator_id, String administrator_password) {
        return administratorMapper.findAdministratorByLogin(administrator_id, administrator_password);
    }
}
