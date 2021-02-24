package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {

    /**
     * 验证教师账号和密码
     *
     * @param teacher_id       账号
     * @param teacher_password 密码
     * @return int
     */
    int verifyTeacher(String teacher_id, String teacher_password);


    /* 查询所有教师 */
    List<Teacher> selectTeachers(Integer start, Integer size, String condition);


    /* 修改教师 */
    Integer updateTeacher(
            @Param("teacher_id") String teacher_id,
            @Param("teacher_password") String teacher_password,
            @Param("teacher_avatar") String teacher_avatar,
            @Param("teacher_phone") String teacher_phone,
            @Param("teacher_email") String teacher_email,
            @Param("teacher_status") Integer teacher_status
    );


    /* 改密码 */
    Integer changePassword(
            @Param("teacher_id") String teacher_id,
            @Param("teacher_password") String password
    );

}
