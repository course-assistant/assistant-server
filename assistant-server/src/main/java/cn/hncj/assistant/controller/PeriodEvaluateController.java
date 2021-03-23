package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.PeriodEvaluateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/periodevaluation")
public class PeriodEvaluateController {

    @Autowired
    PeriodEvaluateService periodEvaluateService;


    @PostMapping("/issue")
    @RoleCheck(RoleCheck.STUDENT)
    public ServerResponse<Object> issue(
            @RequestParam("period_id") Integer period_id,
            @RequestParam("student_id") String student_id,
            @RequestParam("content") String content,
            @RequestParam("degree") Integer degree,
            @RequestParam("quality") Integer quality
    ) {
        periodEvaluateService.issue(period_id, student_id, content, degree, quality);
        return ServerResponse.createSuccess("发布成功");
    }

}
