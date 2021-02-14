package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
