package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.TeacherDTO;
import cn.hncj.assistant.entity.Teacher;

import java.util.List;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface TeacherService {


    /**
     * 分页查询教师
     *
     * @param start start
     * @param size  size
     * @return TeacherDTO
     */
    TeacherDTO selectTeacherByPage(Integer start, Integer size);


    /* 添加教师 */
    int insertTeacher(
            String id,
            String administrator_id,
            String name,
            Integer sex,
            String phone,
            String email
    );
}
