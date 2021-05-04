package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpellCheckingInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/lesson")
public class LessonController {


    @Autowired
    LessonService lessonService;

    @Comment("根据课程id课")
    @GetMapping("/selectbycourseid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectWeekLesson(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", lessonService.selectLessons(id));
    }


    @Comment("添加课时")
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> insert(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("content") String content
    ) {
        lessonService.insert(id, name, content);
        return ServerResponse.createSuccess("添加成功");
    }


    @Comment("删除课时")
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> delete(
            @RequestParam("id") Integer id
    ) {
        lessonService.removeById(id);
        return ServerResponse.createSuccess("删除成功");
    }

}
