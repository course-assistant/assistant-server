package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.WeekGoal;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface WeekGoalService {

    /**
     * 添加周目标
     *
     * @param week_mission_id week_mission_id
     * @param title           title
     * @param content         content
     * @return int
     */
    Integer insert(Integer week_mission_id, String title, String content);


    /**
     * 删除周目标
     *
     * @param id id
     * @return int
     */
    Integer delete(Integer id);


    /**
     * 修改周目标
     *
     * @param id      id
     * @param title   title
     * @param content content
     * @return int
     */
    Integer update(Integer id, String title, String content);


    ///////////////////////////////////////////////

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


}
