package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.WeekService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/week")
public class WeekController {

    @Autowired
    WeekService weekService;

    @GetMapping("/select")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectWeek(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekService.selectWeek(id));
    }

}
