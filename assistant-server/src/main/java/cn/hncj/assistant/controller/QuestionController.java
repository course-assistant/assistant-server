package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Comment("获取课程的所有题目")
    @GetMapping("/all")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> all(
            @RequestParam("course_id") Integer course_id
    ) {
        return ServerResponse.createSuccess("查询成功", questionService.all(course_id));
    }
}
