package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.DiscussionDTO;
import cn.hncj.assistant.entity.Discussion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DiscussionMapper extends BaseMapper<Discussion> {

    /**
     * 根据课程id查询课堂讨论
     *
     * @param course_id course_id
     * @return Discussion
     */
    List<DiscussionDTO> selectByCourseId(@Param("course_id") Integer course_id);


    /**
     * 根据讨论id查询讨论
     *
     * @param id id
     * @return discussionDTO
     */
    DiscussionDTO selectDiscussionByDiscussionId(@Param("discussion_id") Integer id);

}