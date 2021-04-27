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

    /**
     * 根据学时id查询测试
     *
     * @param id period_id
     * @return PeriodTest
     */
    @GetMapping("/selecttestbyperiodid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectPeriodTestByPeriodId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", periodTestService.selectPeriodTestByPeriodId(id));
    }


    /**
     * 给学时添加测试
     *
     * @param id   period_id
     * @param name 测试名字
     * @return int
     */
    @PostMapping("/inserttest")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> insertPeriodTest(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name
    ) {
        periodTestService.insertPeriodTest(id, name);
        return ServerResponse.createSuccess("添加成功");
    }


    /**
     * 发布测试
     *
     * @param id id
     * @return int
     */
    @PostMapping("/issue")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> issuePeriodTest(@RequestParam("id") Integer id) {
        periodTestService.issuePeriodTest(id);
        return ServerResponse.createSuccess("发布成功");
    }


    /* 删除测试 */
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> deletePeriodTest(@RequestParam("id") Integer id){
        periodTestService.deletePeriodTest(id);
        return ServerResponse.createSuccess("删除成功");
    }
}
