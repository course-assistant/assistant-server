package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Discussion;
import cn.hncj.assistant.mapper.CommentMapper;
import cn.hncj.assistant.mapper.DiscussionMapper;
import cn.hncj.assistant.service.DiscussionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
