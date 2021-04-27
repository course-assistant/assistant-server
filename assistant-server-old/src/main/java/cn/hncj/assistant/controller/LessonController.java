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

    @Comment("根据课程id查询周和课")
    @GetMapping("/selectbycourseid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectWeekLesson(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", lessonService.selectWeekLesson(id));
    }

}
