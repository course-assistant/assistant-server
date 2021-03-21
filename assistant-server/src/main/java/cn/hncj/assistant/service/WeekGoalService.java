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


}
