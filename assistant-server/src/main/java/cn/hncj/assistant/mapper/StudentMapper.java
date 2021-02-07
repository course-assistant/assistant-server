package cn.hncj.assistant.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {
    /**
     * 验证学生账号和密码
     *
     * @param student_id       账号
     * @param student_password 密码
     * @return int
     */
    int verifyStudent(String student_id, String student_password);
}
