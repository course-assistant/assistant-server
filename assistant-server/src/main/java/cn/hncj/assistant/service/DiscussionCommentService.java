package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.CommentDTO;
import cn.hncj.assistant.dto.DiscussionDTO;
import cn.hncj.assistant.entity.Discussion;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface DiscussionCommentService {

    /**
     * 根据课程id查询课堂讨论
     *
     * @param course_id course_id
     * @return Discussion
     */
    List<DiscussionDTO> selectDiscussionByCourseId(Integer course_id);


    /**
     * 根据讨论id查询讨论
     *
     * @param id id
     * @return discussionDTO
     */
    DiscussionDTO selectDiscussionByDiscussionId(Integer id);


    /**
     * 发布课堂讨论
     *
     * @param course_id period_id
     * @param title     title
     * @param content   content
     * @return int
     */
    Integer issueDiscussion(Integer course_id, String title, String content);


    /**
     * 删除课堂讨论
     *
     * @param id id
     * @return int
     */
    Integer deleteDiscussion(Integer id);


    /**
     * 查询讨论的评论
     *
     * @param id id
     * @return commentDTO
     */
    List<CommentDTO> selectCommentsByDiscussionId(Integer id);


    /**
     * 发布评论
     *
     * @param discussion_id discussion_id
     * @param student_id    student_id
     * @param content       content
     * @return int
     */
    Integer issueComment(Integer discussion_id, String student_id, String content);



}
