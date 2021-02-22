package cn.hncj.assistant.service;


import cn.hncj.assistant.dto.WeekPeriodDTO;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface WeekPeriodService {

    /**
     * 根据课程id查询周和学时
     *
     * @param courseId id
     * @return week period
     */
    List<WeekPeriodDTO> selectWeekPeriod(Integer courseId);


    /**
     * 给课程添加一个周
     *
     * @param courseId courseId
     * @param name     name
     * @return int
     */
    Integer addWeek(Integer courseId, String name);


    /**
     * 给周添加学时
     *
     * @param weekId weekId
     * @param name   name
     * @param type   type
     * @return int
     */
    Integer addPeriod(Integer weekId, String name, Integer type);


    /**
     * 修改学时
     *
     * @param id     学时id
     * @param name   新名字
     * @param type   新type
     * @param status 新status
     * @return int
     */
    Integer updatePeriod(Integer id, String name, Integer type, Integer status);


    /**
     * 修改周
     *
     * @param id   id
     * @param name name
     * @return int
     */
    Integer updateWeek(Integer id, String name);


    /**
     * 删除学时
     *
     * @param id id
     * @return int
     */
    Integer deletePeriodById(Integer id);


    /**
     * 删除周
     *
     * @param id id
     * @return int
     */
    Integer deleteWeekById(Integer id);
}












