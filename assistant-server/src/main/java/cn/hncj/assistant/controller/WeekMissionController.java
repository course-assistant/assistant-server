package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.WeekMissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/weekmission")
public class WeekMissionController {

    @Autowired
    WeekMissionService weekMissionService;

    @GetMapping("/selectbycourseid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByCourseId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectByCourseId(id));
    }


    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectById(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectById(id));
    }


}
