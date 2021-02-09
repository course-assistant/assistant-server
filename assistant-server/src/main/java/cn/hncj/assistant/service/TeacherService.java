package cn.hncj.assistant.service;

import cn.hncj.assistant.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> selectTeachers(Integer start,Integer size);


    int insertTeacher(
            String id,
            String administrator_id,
            String name,
            Integer sex,
            String phone,
            String email
    );
}
