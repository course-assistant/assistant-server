package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.WeekPeriodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/weekperiod")
public class WeekPeriodController {

    @Autowired
    WeekPeriodService weekPeriodService;

    /* 根据课程id查询周和学时 */
    @GetMapping("/select")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectWeekPeriod(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekPeriodService.selectWeekPeriod(id));
    }

}
