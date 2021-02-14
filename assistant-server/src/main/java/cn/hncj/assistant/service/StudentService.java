package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.StudentDTO;
import cn.hncj.assistant.dto.TeacherDTO;

import java.util.Map;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface StudentService {

    /* 分页查询学生 */
    StudentDTO selectStudentByPage(Integer page, Integer size);

    /* 修改学生 */
    Integer updateStudent(Map<String, Object> map);

    /* 删除学生 */
    Integer deleteStudentById(String id);

}
