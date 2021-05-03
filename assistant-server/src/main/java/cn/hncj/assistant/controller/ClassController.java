package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpellCheckingInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @Comment("根据课程id查询班级")
    @GetMapping("/findbycourseid")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> selectByCourseId(@RequestParam("course_id") String course_id) {
        return ServerResponse.createSuccess("查询成功", classService.selectByCourseId(course_id));
    }


    @Comment("根据班级id查询班级")
    @GetMapping("/findbyclassid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByClassId(@RequestParam("class_id") Integer class_id) {
        return ServerResponse.createSuccess("查询成功", classService.selectByClassId(class_id));
    }


    @Comment("查询班级的学生人数")
    @GetMapping("/countbycourseid")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> countStudent(@RequestParam("class_id") Integer class_id) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("count", classService.countStudent(class_id));
        return ServerResponse.createSuccess("查询成功", map);
    }


    @Comment("添加班级")
    @PostMapping("insert")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> insert(
            @RequestParam("course_id") Integer course_id,
            @RequestParam("name") String name
    ) {
        classService.insertClass(course_id, name);
        return ServerResponse.createSuccess("添加成功");
    }


    /* 删除班级 */
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> delete(@RequestParam("class_id") Integer class_id) {
        classService.deleteClass(class_id);
        return ServerResponse.createSuccess("删除成功");
    }


    /* 学生选课 */
    @PostMapping("/selection")
    @RoleCheck(RoleCheck.STUDENT)
    public ServerResponse<Object> selection(
            @RequestParam("student_id") String student_id,
            @RequestParam("invite_code") String invite_code
    ) {
        classService.selection(student_id, invite_code);
        return ServerResponse.createSuccess("选课成功");
    }


    @Comment("教师给学生选课")
    @PostMapping("/selectionbyteacher")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> selectionByTeacher(
            @RequestParam("student_id") String student_id,
            @RequestParam("class_id") Integer class_id
    ) {
        classService.selectionByTeacher(student_id, class_id);
        return ServerResponse.createSuccess("选课成功");
    }

    @Comment("将学生移出班级")
    @PostMapping("/removestudent")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> removeStudent(
            @RequestParam("student_id") String student_id,
            @RequestParam("class_id") Integer class_id
    ) {
        classService.removeStudent(student_id, class_id);
        return ServerResponse.createSuccess("选移除功");
    }

}
