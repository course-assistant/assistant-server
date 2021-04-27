package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.StudentDTO;
import cn.hncj.assistant.entity.Student;

import java.util.Map;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface StudentService {

    /* 分页查询学生 */
    StudentDTO selectStudentByPage(Integer page, Integer size, String condition);


    /**
     * 根据学生id查询学生
     * @param id id
     * @return student
     */
    Student selectById(String id);


    /**
     * 根据 classId 查询学生
     * @param class_id class_id
     * @return student
     */
    StudentDTO selectStudentsByClassId(Integer class_id);


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
