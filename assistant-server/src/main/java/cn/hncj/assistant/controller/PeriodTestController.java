package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.PeriodTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/periodtest")
public class PeriodTestController {

    @Autowired
    PeriodTestService periodTestService;

    @GetMapping("/selecttestbyperiodid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectPeriodTestByPeriodId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", periodTestService.selectPeriodTestByPeriodId(id));
    }

}
