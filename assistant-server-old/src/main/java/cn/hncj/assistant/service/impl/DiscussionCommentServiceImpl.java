package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.CommentDTO;
import cn.hncj.assistant.dto.DiscussionDTO;
import cn.hncj.assistant.entity.Comment;
import cn.hncj.assistant.entity.Discussion;
import cn.hncj.assistant.mapper.CommentMapper;
import cn.hncj.assistant.mapper.DiscussionMapper;
import cn.hncj.assistant.service.DiscussionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class DiscussionCommentServiceImpl implements DiscussionCommentService {

    @Autowired
    DiscussionMapper discussionMapper;

    @Autowired
    CommentMapper commentMapper;


    /**
     * 根据学时id查询课堂讨论
     *
     * @param period_id period_id
     * @return Discussion
     */
    @Override
    public List<Discussion> selectDiscussionByPeriodId(Integer period_id) {
        return discussionMapper.selectByPeriodId(period_id);
    }


    /**
     * 根据讨论id查询讨论
     *
     * @param id id
     * @return discussionDTO
     */
    @Override
    public DiscussionDTO selectDiscussionByDiscussionId(Integer id) {
        return discussionMapper.selectDiscussionByDiscussionId(id);
    }


    /**
     * 查询讨论的评论
     *
     * @param id id
     * @return commentDTO
     */
    @Override
    public List<CommentDTO> selectCommentsByDiscussionId(Integer id) {
        return commentMapper.selectCommentsByDiscussionId(id);
    }


    /**
     * 发布课堂讨论
     *
     * @param period_id period_id
     * @param title     title
     * @param content   content
     * @return int
     */
    @Override
    public Integer issueDiscussion(Integer period_id, String title, String content) {
        Discussion discussion = new Discussion()
                .setPeriod_id(period_id)
                .setDiscussion_title(title)
                .setDiscussion_content(content)
                .setDiscussion_date(new Date());
        return discussionMapper.insert(discussion);
    }


    /**
     * 删除课堂讨论
     *
     * @param id id
     * @return int
     */
    @Override
    public Integer deleteDiscussion(Integer id) {
        return discussionMapper.deleteById(id);
    }


    /**
     * 发布评论
     *
     * @param discussion_id discussion_id
     * @param student_id    student_id
     * @param content       content
     * @return int
     */
    @Override
    public Integer issueComment(Integer discussion_id, Integer student_id, String content) {
        Comment comment = new Comment()
                .setDiscussion_id(discussion_id)
                .setStudent_id(student_id)
                .setComment_content(content)
                .setComment_date(new Date());
        return commentMapper.insert(comment);
    }
}
