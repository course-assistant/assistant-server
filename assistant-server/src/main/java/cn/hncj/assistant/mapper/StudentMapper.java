package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {
    /* 验证学生账号和密码 */
    int verifyStudent(String student_id, String student_password);


    /* 查询所有学生 */
    List<Student> selectStudents(Integer start, Integer size, String condition);


    /* 根据 classId 查询学生 */
    List<Student> selectStudentsByClassId(@Param("class_id") Integer class_id);


    /* 修改学生 */
    Integer updateStudent(
            @Param("student_id") String student_id,
            @Param("student_password") String student_password,
            @Param("student_avatar") String student_avatar,
            @Param("student_phone") String student_phone,
            @Param("student_email") String student_email,
            @Param("student_status") Integer student_status
    );


    /* 查询课程的所有学生id */
    List<String> selectIdByCourseId(@Param("course_id") Integer course_id);
}
