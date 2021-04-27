package cn.hncj.assistant.controller;

import cn.hncj.assistant.annotation.Comment;
import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.common.ServerResponse;
import cn.hncj.assistant.service.DiscussionCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"SpellCheckingInspection", "SpringJavaAutowiredFieldsWarningInspection"})
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/discussioncomment")
public class DiscussionCommentController {

    @Autowired
    DiscussionCommentService discussionCommentService;

    @Comment("根据课程id查询讨论")
    @GetMapping("/selectbycourse")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectDiscussionByCourseId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", discussionCommentService.selectDiscussionByCourseId(id));
    }


    @Comment("根据讨论id查询讨论")
    @GetMapping("/selectbyid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectDiscussionByDiscussionId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", discussionCommentService.selectDiscussionByDiscussionId(id));
    }


    @Comment("发布课堂讨论")
    @PostMapping("/issuediscussion")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> issueDiscussion(
            @RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        discussionCommentService.issueDiscussion(id, title, content);
        return ServerResponse.createSuccess("发布成功");
    }


    @Comment("删除课堂讨论")
    @PostMapping("/deletediscussion")
    @RoleCheck(RoleCheck.TEACHER)
    public ServerResponse<Object> deleteDiscussion(@RequestParam("id") Integer id) {
        discussionCommentService.deleteDiscussion(id);
        return ServerResponse.createSuccess("删除成功");
    }


    @Comment("根据讨论id查询评论")
    @GetMapping("/selectcommentsbydisscussionid")
    @RoleCheck(RoleCheck.USER)
    public ServerResponse<Object> selectCommentsByDiscussionId(@RequestParam("id") Integer id) {
        return ServerResponse.createSuccess("查询成功", discussionCommentService.selectCommentsByDiscussionId(id));
    }


    @Comment("发布评论")
    @PostMapping("/issuecomment")
    @RoleCheck(RoleCheck.STUDENT)
    public ServerResponse<Object> issueComment(
            @RequestParam("discussion_id") Integer discussion_id,
            @RequestParam("student_id") String student_id,
            @RequestParam("content") String content
    ) {
        discussionCommentService.issueComment(discussion_id, student_id, content);
        return ServerResponse.createSuccess("发布成功");
    }

}
