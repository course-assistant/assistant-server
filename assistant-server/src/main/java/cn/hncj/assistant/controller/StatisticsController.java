package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpellCheckingInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @Comment("统计课程信息")
    @GetMapping("/courseinfo")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> profile(@RequestParam("id") Integer course_id) {
        return ServerResponse.createSuccess("查询成功", statisticsService.profile(course_id));
    }

}
