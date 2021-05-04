package cn.hncj.assistant.service;


import cn.hncj.assistant.dto.WeekInfoDTO;
import cn.hncj.assistant.entity.Week;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface WeekService extends IService<Week> {


    /**
     * 根据课程id查询所有周
     *
     * @param course_id course_id
     * @return Week
     */
    List<Week> selectWeek(Integer course_id);


    /**
     * 根据周id查询周
     *
     * @param week_id week_id
     * @return week
     */
    Week selectById(Integer week_id);


    /**
     * 查询周信息
     *
     * @param course_id course_id
     * @return WeekInfoDTO
     */
    WeekInfoDTO select(Integer course_id);


    /**
     * 发布任务
     *
     * @param mission_id mission_id
     * @return int
     */
    Integer issueMission(Integer mission_id);

    /**
     * 删除任务
     *
     * @param mission_id mission_id
     * @return int
     */
    Integer deleteMission(Integer mission_id);

}












