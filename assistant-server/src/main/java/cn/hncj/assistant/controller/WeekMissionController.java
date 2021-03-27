package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
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


    @Comment("根据周id查询周任务")
    @GetMapping("/selectbyweekid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByWeekId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectByWeekId(id));
    }


    @Comment("根据周任务id查询周任务")
    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectById(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectById(id));
    }


    @Comment("添加周任务")
    @PostMapping("/insert")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> insert(
            @RequestParam("week_id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("type") Integer type
    ) {
        weekMissionService.insert(id, name, type);
        return ServerResponse.createSuccess("添加成功");
    }


    @Comment("删除周任务")
    @PostMapping("/delete")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> delete(@RequestParam("ids") Integer[] ids) {
        weekMissionService.delete(ids);
        return ServerResponse.createSuccess("删除成功");
    }


    @Comment("发布周任务")
    @PostMapping("/issue")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> issue(@RequestParam("ids") Integer[] ids) {
        weekMissionService.issue(ids);
        return ServerResponse.createSuccess("发布成功");
    }



    @Comment("修改周任务内容")
    @PostMapping("/updatecontent")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> updateContent(
            @RequestParam("id") Integer id,
            @RequestParam("content") String content
    ) {
        weekMissionService.updateContent(id, content);
        return ServerResponse.createSuccess("修改成功");
    }


    ////////////////////////////////

    /* 根据课程id查询周任务 */
    @GetMapping("/selectbycourseid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByCourseId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectByCourseId(id));
    }


}
