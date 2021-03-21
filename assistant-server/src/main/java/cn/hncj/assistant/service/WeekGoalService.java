package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.WeekGoal;

import java.util.List;

public interface WeekGoalService {

    /**
     * 根据周id查询周目标
     *
     * @param id 周id
     * @return weekGoal
     */
    List<WeekGoal> selectByWeekId(Integer id);


    /**
     * 添加周目标
     *
     * @param week_id week_id
     * @param type    type
     * @param content content
     * @return int
     */
    Integer insert(Integer week_id, Integer type, String content);

}
