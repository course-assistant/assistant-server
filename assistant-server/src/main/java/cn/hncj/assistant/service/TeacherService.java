package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.TeacherDTO;

import java.util.Map;


@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface TeacherService {


    /**
     * 分页查询教师
     *
     * @param page page
     * @param size size
     * @return TeacherDTO
     */
    TeacherDTO selectTeacherByPage(Integer page, Integer size);


    /* 修改教师 */
    Integer updateTeacher(Map<String, Object> map);

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
