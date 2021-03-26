package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.WeekGoal;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface WeekGoalService {

//    /**
//     * 根据周任务id查询周目标
//     *
//     * @param id id
//     * @return WeekGoal
//     */
//    List<WeekGoal> selectByWeekMissionId(Integer id);

    ///////

    /**
     * 根据周id查询周目标
     *
     * @param id 周id
     * @return weekGoal
     */
    List<WeekGoal> selectByWeekId(Integer id);


//    /**
//     * 添加周目标
//     *
//     * @param week_id week_id
//     * @param title   title
//     * @param content content
//     * @return int
//     */
//    Integer insert(Integer week_id, String title, String content);


    /**
     * 删除周目标
     *
     * @param id id
     * @return int
     */
    Integer delete(Integer id);
}
