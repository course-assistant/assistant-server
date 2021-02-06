package cn.hncj.assistant.mapper;

import cn.hncj.assistant.pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministratorMapper {
    public Administrator findAdministratorByLogin(
            @Param("administrator_id") String administrator_id,
            @Param("administrator_password") String administrator_password
    );
}
