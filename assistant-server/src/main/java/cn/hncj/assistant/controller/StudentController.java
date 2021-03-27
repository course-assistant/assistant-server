package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.dto.StudentDTO;
import cn.hncj.assistant.entity.Student;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.StudentService;
import cn.hncj.assistant.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SuppressWarnings("SpellCheckingInspection")
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
    @RoleCheck(RoleCheck.ADMIN)
    public ServerResponse<Object> all(@RequestParam("page") Integer page, @RequestParam("size") Integer size, String condition) {
        StudentDTO studentDTO = studentService.selectStudentByPage(page, size, condition);
        if (studentDTO.getStudents().isEmpty()) {
            return ServerResponse.createEmptyQuery();
        }
        return ServerResponse.createSuccess("查询成功", studentDTO);
    }


    @Comment("根据班级id查询所有学生")
    @GetMapping("/selectbyclassid")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> selectStudentsByClassId(@RequestParam("class_id") Integer class_id) {
        return ServerResponse.createSuccess("查询成功", studentService.selectStudentsByClassId(class_id));
    }


    /* 根据id查询 */
    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.STUDENT)
    public ServerResponse<Object> selectbyid(@RequestParam("id") String id) {
        Student student = studentService.selectById(id);
        if (student == null) {
            return ServerResponse.createEmptyQuery();
        }
        return ServerResponse.createSuccess("查询成功", student);
    }


    /* 添加学生 */
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.ADMIN)
    public ServerResponse<Object> insert(
            @RequestParam("id") String id,
            @RequestParam("admin_id") String admin_id,
            @RequestParam("name") String name,
            Integer sex,
            String phone,
            String email) {
        studentService.insertStudent(id, admin_id, name, sex, phone, email);
        HashMap<String, String> data = new HashMap<>();
        data.put("id", id);
        return ServerResponse.createSuccess("添加成功", data);
    }

    /* 重置教师 */
    @PostMapping("/reset")
    @RoleCheck(RoleCheck.ADMIN)
    public ServerResponse<Object> reset(@RequestParam("id") String id) {
        log.info("重置学生");
        HashMap<String, Object> map = new HashMap<>();
        map.put("student_id", id);
        map.put("student_password", MD5Util.MD5EncodeUpper("000000"));
        studentService.updateStudent(map);
        return ServerResponse.createSuccess("重置成功");
    }


    /* 删除学生 */
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.ADMIN)
    public ServerResponse<Object> delete(@RequestParam("id") String id) {
        studentService.deleteStudentById(id);
        return ServerResponse.createSuccess("删除成功");
    }

    /* 修改学生 */
    @PostMapping("/update")
    @RoleCheck(RoleCheck.STUDENT)
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
        if (phone != null) {
            map.put("student_phone", phone);
        }
        if (avatar != null) {
            map.put("student_avatar", avatar);
        }
        if (map.isEmpty()) {
            throw new ServerException("请至少传入一个参数");
        }
        map.put("student_id", id);
        studentService.updateStudent(map);
        return ServerResponse.createSuccess("修改成功");
    }

    /* 改变状态 */
    @PostMapping("/status")
    @RoleCheck(RoleCheck.ADMIN)
    public ServerResponse<Object> status(@RequestParam("id") String id, @RequestParam("status") Integer status) {
        if (status < 0 || status > 1) {
            throw new ServerException("status只能为 0或1");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("student_id", id);
        map.put("student_status", status);
        studentService.updateStudent(map);
        return ServerResponse.createSuccess("修改成功");
    }

}
