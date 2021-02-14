package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.TeacherService;
import cn.hncj.assistant.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    TeacherService teacherService;
    final static Logger log = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

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
     * @param page 页数
     * @param size 个数
     */
    @GetMapping("/all")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> all(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        log.info("查询教师");
        return ServerResponse.createSuccess("查询成功", teacherService.selectTeacherByPage(page, size));
    }


    /* 重置教师 */
    @PostMapping("/reset")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> reset(@RequestParam("id") String id) {
        log.info("重置教师");
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacher_id", id);
        map.put("teacher_password", MD5Util.MD5EncodeUpper("000000"));
        teacherService.updateTeacher(map);
        return ServerResponse.createSuccess("重置成功");
    }

    /* 删除教师 */
    @PostMapping("/delete")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> delete(@RequestParam("id") String id) {
        log.info("删除教师");
        teacherService.deleteTeacherById(id);
        return ServerResponse.createSuccess("删除成功");
    }

    /* 改变状态 */
    @PostMapping("/status")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> status(@RequestParam("id") String id, @RequestParam("status") Integer status) {
        log.info("改变状态");
        log.info("id: {}", id);
        log.info("status: {}", status);
        if (status < 0 || status > 1) {
            throw new ServerException("status只能为 0或1");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacher_id", id);
        map.put("teacher_status", status);
        teacherService.updateTeacher(map);
        return ServerResponse.createSuccess("修改成功");
    }

    /* 修改教师 */
    @PostMapping("/update")
    @RoleCheck(role = RoleCheck.TEACHER)
    public ServerResponse<Object> update(
            @RequestParam("id") String id,
            String phone,
            String email
    ) {
        HashMap<String, Object> map = new HashMap<>();
        if (phone != null) {
            map.put("teacher_phone", phone);
        }
        if (email != null) {
            map.put("teacher_email", email);
        }
        if(map.isEmpty()){
            throw new ServerException("请至少传入一个参数");
        }
        map.put("teacher_id", id);
        teacherService.updateTeacher(map);
        return ServerResponse.createSuccess("修改成功");
    }

}
