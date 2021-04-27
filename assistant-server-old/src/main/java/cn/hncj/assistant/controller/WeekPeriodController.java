package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.exception.ServerException;
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


    /**
     * 根据学时id查询学时
     *
     * @param id id
     * @return period
     */
    @GetMapping("/selectperiodbyperiodid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectPeriodByPeriodId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekPeriodService.selectPeriodByPeriodId(id));
    }


    /* 给课程添加周 */
    @PostMapping("/addweek")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> addWeek(
            @RequestParam("course_id") Integer course_id,
            @RequestParam("name") String name) {
        weekPeriodService.addWeek(course_id, name);
        return ServerResponse.createSuccess("添加成功");
    }


    /* 给周添加学时 */
    @PostMapping("/addperiod")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> addPeriod(
            @RequestParam("week_id") Integer week_id,
            @RequestParam("name") String name,
            @RequestParam("type") Integer type) {
        weekPeriodService.addPeriod(week_id, name, type);
        return ServerResponse.createSuccess("添加成功");
    }


    /* 修改学时 */
    @PostMapping("/updateperiod")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> updatePeriod(
            @RequestParam("id") Integer id,
            String name,
            String content,
            Integer type,
            Integer status
    ) {
        // 判断是否全为空
        if (name == null && type == null && status == null && content == null) {
            throw new ServerException("请至少传入一个参数");
        }
        weekPeriodService.updatePeriod(id, name, content, type, status);
        return ServerResponse.createSuccess("修改成功");
    }


    /* 修改周 */
    @PostMapping("/updateweek")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> updateWeek(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name
    ) {
        weekPeriodService.updateWeek(id, name);
        return ServerResponse.createSuccess("修改成功");
    }


    /* 删除学时 */
    @PostMapping("/deleteperiod")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> deletePeriod(@RequestParam("id") Integer id) {
        weekPeriodService.deletePeriodById(id);
        return ServerResponse.createSuccess("删除成功");

    }


    /* 删除周 */
    @PostMapping("/deleteweek")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> deleteWeek(@RequestParam("id") Integer id) {
        weekPeriodService.deleteWeekById(id);
        return ServerResponse.createSuccess("删除成功");

    }

}
