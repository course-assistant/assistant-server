package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public ServerResponse<Object> addTeacher(String id, String administrator_id, String name, Integer sex, String phone, String email) {
        teacherService.insertTeacher(id, administrator_id, name, sex, phone, email);
        HashMap<String, String> data = new HashMap<>();
        data.put("teacher_id", id);
        return ServerResponse.createSuccess("添加成功", data);
    }


    /**
     * 分页查询教师
     * 管理员有权限访问此接口
     *
     * @param start 初始位置
     * @param size  个数
     */
    @CrossOrigin
    @GetMapping("/all")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> all(Integer start, Integer size) {
        return ServerResponse.createSuccess("查询成功", teacherService.selectTeachers(start, size));
    }


}
