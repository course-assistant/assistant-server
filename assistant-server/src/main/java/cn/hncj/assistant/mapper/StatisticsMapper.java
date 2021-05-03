package cn.hncj.assistant.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface StatisticsMapper {

    // 统计任务数
    Integer countMission(Integer course_id);


    // 统计讨论数
    Integer countDiscussion(Integer course_id);
}