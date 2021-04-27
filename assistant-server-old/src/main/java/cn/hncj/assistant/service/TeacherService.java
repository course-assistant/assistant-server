package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.TeacherDTO;
import cn.hncj.assistant.entity.Teacher;

import java.util.Map;


@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface TeacherService {

    /* 分页查询教师 */
    TeacherDTO selectTeacherByPage(Integer page, Integer size, String condition);

    /**
     * 根据id查询教师
     *
     * @param id id
     * @return teacher
     */
    Teacher selectById(String id);

    /* 修改教师 */
    Integer updateTeacher(Map<String, Object> map);


    /* 修改密码 */
    Integer changePassword(String id, String oldPwd, String newPwd);


    /* 删除教师 */
    Integer deleteTeacherById(String id);


    /* 注销 */
    Integer cancel(String id, String password);


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
