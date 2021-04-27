package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.WeekGoal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WeekGoalMapper extends BaseMapper<WeekGoal> {

    /**
     * 修改周目标
     *
     * @param id      id
     * @param title   title
     * @param content content
     * @return int
     */
    Integer updateWeekGoal(
            @Param("week_goal_id") Integer id,
            @Param("week_goal_title") String title,
            @Param("week_goal_content") String content
    );

}