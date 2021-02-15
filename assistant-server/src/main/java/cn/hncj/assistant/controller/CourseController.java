package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    final static Logger log = LoggerFactory.getLogger(CourseController.class);

    /**
     * 查询课程
     *
     * @param id     教师id
     * @param page   page
     * @param size   size
     * @param status status
     * @return courses
     */
    @GetMapping("/find")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> findStarted(
            @RequestParam("id") String id,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            Integer status
    ) {
        log.info("查询正在进行的课程");
        log.info("id: {}", id);
        log.info("page: {}", page);
        log.info("size: {}", size);
        log.info("status: {}", status);
        // 根据情况返回
        if (status == null) {
            return ServerResponse.createSuccess("查询成功", courseService.findCourseByTeacherId(id, page, size));
        }
        if (status < 1 || status > 3) {
            throw new ServerException("status只能为 1 2 3");
        }
        switch (status) {
            case 1:
                return ServerResponse.createSuccess("查询成功", courseService.findStartedCourseByTeacherId(id, page, size));

            case 2:
                return ServerResponse.createSuccess("查询成功", courseService.findEndedCourseByTeacherId(id, page, size));

            case 3:
                return ServerResponse.createSuccess("查询成功", courseService.findDeletedCourseByTeacherId(id, page, size));

            default:
                return ServerResponse.createSuccess("查询成功", courseService.findCourseByTeacherId(id, page, size));
        }
    }


    /**
     * 添加课程
     *
     * @param teacher_id 教师id
     * @param name       name
     * @param cover      cover
     * @return response
     */
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> insert(
            @RequestParam("teacher_id") String teacher_id,
            @RequestParam("name") String name,
            @RequestParam("cover") String cover) {
        courseService.insertCourse(teacher_id, name, cover);
        return ServerResponse.createSuccess("添加成功");
    }

}
