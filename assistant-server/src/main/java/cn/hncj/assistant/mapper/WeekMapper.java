package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.WeekDTO;
import cn.hncj.assistant.dto.WeekMissionDTO2;
import cn.hncj.assistant.entity.Week;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WeekMapper extends BaseMapper<Week> {

    /**
     * 修改周
     *
     * @param week_id   week_id
     * @param week_name week_name
     * @return int
     */
    Integer updateWeek(
            @Param("week_id") Integer week_id,
            @Param("week_name") String week_name);


    /**
     * 查询weekDTO
     *
     * @param id course_id
     * @return WeekDTO
     */
    List<WeekDTO> selectWeekDTO(@Param("course_id") Integer id);


    List<WeekMissionDTO2> selectWeekMissionDTO2(@Param("week_id") Integer week_id);


    WeekMissionDTO2 selectMissionById(@Param("week_mission_id") Integer id);


    // 查询周任务的完成人数
    Integer countMissionViews(@Param("week_mission_id") Integer id);


    // 学生查看任务
    Integer viewMission(@Param("student_id") String student_id, @Param("week_mission_id") Integer week_mission_id);
}