package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.TeacherDTO;
import cn.hncj.assistant.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> selectTeachers(Integer start, Integer size);


    /**
     * 分页查询教师
     *
     * @param start start
     * @param size  size
     * @return TeacherDTO
     */
    TeacherDTO selectTeacherByPage(Integer start, Integer size);


    int insertTeacher(
            String id,
            String administrator_id,
            String name,
            Integer sex,
            String phone,
            String email
    );
}
