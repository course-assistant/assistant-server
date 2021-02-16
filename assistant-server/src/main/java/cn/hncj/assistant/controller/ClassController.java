package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpellCheckingInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;

    /* 根据课程id查询班级 */
    @GetMapping("/findbycourseid")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> selectByCourseId(@RequestParam("course_id") String course_id) {
        return ServerResponse.createSuccess("查询成功", classService.selectByCourseId(course_id));
    }


    /* 添加/创建班级 */
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

}
