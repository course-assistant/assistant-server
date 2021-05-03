package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpellCheckingInspection", "DuplicatedCode"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;


    @Comment("根据教师id查询课程")
    @GetMapping("/findbyteacherid")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> selectCourseByTeacherId(
            @RequestParam("id") String id,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            Integer status
    ) {
        return ServerResponse.createSuccess("查询成功", courseService.selectCourseByTeacherId(id, page, size, status));
    }


    @Comment("根据学生id查询课程")
    @GetMapping("/findbystudentid")
    @RoleCheck(RoleCheck.STUDENT)
    public ServerResponse<Object> selectCourseByStudentId(
            @RequestParam("id") String id,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            Integer status
    ) {
        return ServerResponse.createSuccess("查询成功", courseService.selectCourseByStudentId(id, page, size, status));
    }


    @Comment("根据课程id查询课程")
    @GetMapping("/findbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> findByCourseId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", courseService.findByCourseId(id));
    }


    @Comment("删除课程")
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> deleteCourse(@RequestParam("id") Integer id) {
        courseService.deleteCourse(id);
        return ServerResponse.createSuccess("删除成功");
    }


    @Comment("手动添加课程")
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> insert(
            @RequestParam("teacher_id") String teacher_id,
            @RequestParam("name") String name,
            @RequestParam("cover") String cover,
            @RequestParam("week") Integer week) {
        courseService.insertCourse(teacher_id, name, cover, week);
        return ServerResponse.createSuccess("添加成功");
    }


    /**
     * 修改课程
     *
     * @param teacher_id teacher_id
     * @param course_id  course_id
     * @param name       name
     * @param cover      cover
     * @param status     status
     * @return response
     */
    @PostMapping("/update")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> update(
            @RequestParam("teacher_id") String teacher_id,
            @RequestParam("course_id") Integer course_id,
            String name,
            String cover,
            Integer status
    ) {
        HashMap<String, Object> map = new HashMap<>();
        if (name != null) {
            map.put("course_name", name);
        }
        if (cover != null) {
            map.put("course_cover", cover);
        }
        if (status != null) {
            map.put("course_status", status);
        }
        if (map.isEmpty()) {
            throw new ServerException("请至少传入一个参数");
        }
        map.put("teacher_id", teacher_id);
        map.put("course_id", course_id);
        courseService.updateCourse(map);
        return ServerResponse.createSuccess("修改成功");
    }

}
