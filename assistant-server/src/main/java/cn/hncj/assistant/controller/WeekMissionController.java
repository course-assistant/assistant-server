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

    /* 根据课程id查询周任务 */
    @GetMapping("/selectbycourseid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByCourseId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectByCourseId(id));
    }


    /* 根据周任务id查询周任务 */
    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectById(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectById(id));
    }


    /* 根据周查询周任务 */
    @GetMapping("/selectbyweekid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectByWeekId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", weekMissionService.selectByWeekId(id));
    }


    /* 修改周任务内容 */
    @PostMapping("/updatecontent")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> updateContent(
            @RequestParam("id") Integer id,
            @RequestParam("content") String content
    ) {
        weekMissionService.updateContent(id, content);
        return ServerResponse.createSuccess("修改成功");
    }
}
