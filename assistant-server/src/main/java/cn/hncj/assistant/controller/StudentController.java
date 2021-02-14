package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    StudentService studentService;
    final static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    /* 分页查询学生 */
    @GetMapping("/all")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> all(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        log.info("查询学生");
        return ServerResponse.createSuccess("查询成功", studentService.selectStudentByPage(page, size));
    }

    /* 删除学生 */
    @PostMapping("/delete")
    @RoleCheck(role = RoleCheck.ADMIN)
    public ServerResponse<Object> delete(@RequestParam("id") String id) {
        log.info("删除学生");
        studentService.deleteStudentById(id);
        return ServerResponse.createSuccess("删除成功");
    }

    /* 修改学生 */
    @PostMapping("/update")
    @RoleCheck(role = RoleCheck.STUDENT)
    public ServerResponse<Object> update(
            @RequestParam("id") String id,
            String password,
            String email,
            String phone,
            String avatar
    ) {
        HashMap<String, Object> map = new HashMap<>();
        if (password != null) {
            map.put("student_password", password);
        }
        if (email != null) {
            map.put("student_email", email);
        }
        if (password != null) {
            map.put("student_phone", phone);
        }
        if (email != null) {
            map.put("student_avatar", avatar);
        }
        if (map.isEmpty()) {
            throw new ServerException("请至少传入一个参数");
        }
        map.put("student_id", id);
        studentService.updateStudent(map);
        return ServerResponse.createSuccess("修改成功");
    }

}
