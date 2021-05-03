package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.mapper.ClassMapper;
import cn.hncj.assistant.mapper.StatisticsMapper;
import cn.hncj.assistant.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    StatisticsMapper statisticsMapper;

    @Autowired
    ClassMapper classMapper;

    /**
     * 统计课程信息
     *
     * @param course_id course_id
     * @return 概要信息
     */
    @Override
    public Map<String, Object> profile(Integer course_id) {
        HashMap<String, Object> map = new HashMap<>();

        // 课程任务数
        map.put("mission_num", statisticsMapper.countMission(course_id));

        // 学生人数
        map.put("student_num", classMapper.countStudent(course_id));

        // 讨论话题数
        map.put("discussion_num", statisticsMapper.countDiscussion(course_id));

        // 题库数
        map.put("question_num", 105);

        // 随堂测试数
        map.put("test_num", 4);

        return map;
    }
}
