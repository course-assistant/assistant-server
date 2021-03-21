package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.WeekGoalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/weekgoal")
public class WeekGoalController {

    @Autowired
    WeekGoalService weekGoalService;


    @GetMapping("/selectbyweekid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByWeekId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekGoalService.selectByWeekId(id));
    }

}
