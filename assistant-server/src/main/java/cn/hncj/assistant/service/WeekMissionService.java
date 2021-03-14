package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.WeekMission;

import java.util.List;

public interface WeekMissionService {
    /**
     * 根据课程id 查询所有周任务的id和名称
     *
     * @param id id
     * @return WeekMission
     */
    List<WeekMission> selectByCourseId(Integer id);


    /**
     * 根据id查询周任务
     *
     * @param id id
     * @return WeekMission
     */
    WeekMission selectById(Integer id);


    /**
     * 修改周任务内容
     *
     * @param id      id
     * @param content content
     * @return int
     */
    Integer updateContent(Integer id, String content);
}
