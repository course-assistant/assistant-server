package cn.hncj.assistant.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TeacherMapper {

    /**
     * 验证教师账号和密码
     * @param teacher_id 账号
     * @param teacher_password 密码
     * @return int
     */
    int verifyTeacher(String teacher_id, String teacher_password);
}
