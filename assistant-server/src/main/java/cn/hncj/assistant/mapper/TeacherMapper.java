package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    /**
     * 验证教师账号和密码
     *
     * @param teacher_id       账号
     * @param teacher_password 密码
     * @return int
     */
    int verifyTeacher(String teacher_id, String teacher_password);


    /* 查询所有教师 */
    List<Teacher> selectTeachers(Integer start, Integer size);


    /* 教师数量 */
    Integer countTeacher();

    /* 添加教师 */
    int insertTeacher(
            @Param("teacher_id") String teacher_id,
            @Param("administrator_id") String administrator_id,
            @Param("teacher_name") String teacher_name,
            @Param("teacher_Sex") Integer teacher_Sex,
            @Param("teacher_phone") String teacher_phone,
            @Param("teacher_email") String teacher_email
    );
}
