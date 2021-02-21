package cn.hncj.assistant.service;


import cn.hncj.assistant.dto.WeekPeriodDTO;

import java.util.List;

public interface WeekPeriodService {

    /**
     * 根据课程id查询周和学时
     * @param courseId id
     * @return week period
     */
    List<WeekPeriodDTO> selectWeekPeriod(Integer courseId);
}
