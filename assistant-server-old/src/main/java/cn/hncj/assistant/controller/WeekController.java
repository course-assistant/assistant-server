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


    @GetMapping("/selectweek")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> select(@RequestParam("course_id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekService.select(id));
    }


}
