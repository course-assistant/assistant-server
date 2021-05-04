package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.LessonDTO;
import cn.hncj.assistant.entity.Lesson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LessonMapper extends BaseMapper<Lesson> {

    /**
     * 根据课程id查询课
     *
     * @param id 课程id
     * @return WeekLessonDTO
     */
    List<LessonDTO> selectLessons(@Param("course_id") Integer id);


    /**
     * 查询lesson的平均评价
     *
     * @param lesson_id lesson_id
     * @return map
     */
    Map<String, Object> selectAvgEvaluation(@Param("lesson_id") Integer lesson_id);


    /**
     * 修改课时内容
     *
     * @param id      id
     * @param content content
     * @return int
     */
    Integer updateLesson(@Param("lesson_id") Integer id, @Param("lesson_content") String content);

}