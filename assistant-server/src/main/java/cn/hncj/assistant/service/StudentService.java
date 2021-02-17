package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.StudentDTO;

import java.util.Map;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface StudentService {

    /* 分页查询学生 */
    StudentDTO selectStudentByPage(Integer page, Integer size);

    /* 添加学生 */
    int insertStudent(
            String id,
            String administrator_id,
            String name,
            Integer sex,
            String phone,
            String email
    );

    /* 修改学生 */
    Integer updateStudent(Map<String, Object> map);

    /* 删除学生 */
    Integer deleteStudentById(String id);

}
