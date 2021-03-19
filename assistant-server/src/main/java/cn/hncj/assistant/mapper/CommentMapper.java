package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.CommentDTO;
import cn.hncj.assistant.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {


    /**
     * 查询讨论的评论
     *
     * @param id id
     * @return commentDTO
     */
    List<CommentDTO> selectCommentsByDiscussionId(@Param("discussion_id") Integer id);


}