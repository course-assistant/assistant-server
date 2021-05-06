package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.service.WeekService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpellCheckingInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/week")
public class WeekController {

    @Autowired
    WeekService weekService;


    @Comment("根据课程id查询所有周")
    @GetMapping("/select")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectWeek(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekService.selectWeek(id));
    }


    @Comment("根据周id查询周")
    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectById(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekService.selectById(id));
    }


    @Comment("根据周任务id查询周任务")
    @GetMapping("/selectmissionbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectMissionById(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekService.selectMissionById(id));
    }


    @Comment("添加周")
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> isnert(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name
    ) {
        Week week = new Week()
                .setWeek_name(name)
                .setCourse_id(id)
                .setWeek_status(2);
        weekService.save(week);
        return ServerResponse.createSuccess("添加成功");
    }


    @Comment("删除周")
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> delete(@RequestParam("id") Integer id) {
        weekService.removeById(id);
        return ServerResponse.createSuccess("删除成功");
    }


    @Comment("查询周信息")
    @GetMapping("/selectweek")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> select(@RequestParam("course_id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekService.select(id));
    }


    @Comment("发布任务")
    @PostMapping("/issuemission")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> issueMission(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("发布成功", weekService.issueMission(id));
    }


    @Comment("删除任务")
    @PostMapping("/deletemission")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> deleteMission(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("删除成功", weekService.deleteMission(id));
    }


    @Comment("学生查看任务")
    @PostMapping("/viewmission")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> viewMission(
            @RequestParam("student_id") String student_id,
            @RequestParam("mission_id") Integer mission_id
    ) {
        return ServerResponse.createSuccess("添加成功", weekService.viewMission(student_id, mission_id));
    }


}
