package cn.hncj.assistant.service;


import cn.hncj.assistant.dto.WeekPeriodDTO;

import java.util.List;

public interface WeekPeriodService {

    /**
     * 根据课程id查询周和学时
     *
     * @param courseId id
     * @return week period
     */
    List<WeekPeriodDTO> selectWeekPeriod(Integer courseId);


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

}












