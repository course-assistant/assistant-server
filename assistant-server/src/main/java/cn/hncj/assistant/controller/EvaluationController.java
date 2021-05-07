package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.EvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectById(
            @RequestParam("id") Integer id
    ) {
        return ServerResponse.createSuccess("查询成功", evaluationService.selectById(id));
    }


    @PostMapping("/issue")
    @RoleCheck(RoleCheck.STUDENT)
    public ServerResponse<Object> issue(
            @RequestParam("lesson_id") Integer lesson_id,
            @RequestParam("student_id") String student_id,
            @RequestParam("content") String content,
            @RequestParam("degree") Integer degree,
            @RequestParam("quality") Integer quality

    ) {
        return ServerResponse.createSuccess("评价成功",
                evaluationService.issue(lesson_id, student_id,content,degree,quality));
    }


}
