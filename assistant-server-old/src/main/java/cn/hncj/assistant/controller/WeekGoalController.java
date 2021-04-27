package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
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


    @Comment("给周添加周目标")
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> insert(
            @RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        weekGoalService.insert(id, title, content);
        return ServerResponse.createSuccess("添加成功");
    }


    @Comment("删除周目标")
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> delete(@RequestParam("id") Integer id) {
        weekGoalService.delete(id);
        return ServerResponse.createSuccess("删除成功");
    }


    @Comment("修改周目标")
    @PostMapping("/update")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> updateWeekGoal(
            @RequestParam("id") Integer id,
            String title,
            String content
    ) {
        weekGoalService.update(id, title, content);
        return ServerResponse.createSuccess("修改成功");
    }


    ///////////////////////////////

    /* 查询周目标 */
    @GetMapping("/selectbyweekid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByWeekId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekGoalService.selectByWeekId(id));
    }


}
