package cn.hncj.assistant.service;


import java.util.Map;

public interface StatisticsService {

    /**
     * 统计课程信息
     *
     * @param course_id course_id
     * @return 概要信息
     */
    Map<String, Object> profile(Integer course_id);

}
