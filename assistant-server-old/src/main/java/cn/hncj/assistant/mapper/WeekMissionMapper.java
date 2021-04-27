package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.WeekMissionDTO;
import cn.hncj.assistant.entity.WeekMission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
@Mapper
@Repository
public interface WeekMissionMapper extends BaseMapper<WeekMission> {


    /**
     * 根据课程id查询所有周任务的id
     *
     * @param id course_id
     * @return int
     */
    List<Integer> selectWeekMissionIdsByCourseId(@Param("course_id") Integer id);


    /* 判断学生有没有查看该任务 */
    Integer viewsMission(
            @Param("student_id") String student_id,
            @Param("week_mission_id") Integer mission_id
    );


    /**
     * 根据周id查询周任务
     *
     * @param id id
     * @return WeekMissionDTO
     */
    List<WeekMissionDTO> selectByWeekId(@Param("week_id") Integer id);


    /**
     * 查询周任务的查看次数
     *
     * @param week_mission_id week_mission_id
     * @return int
     */
    Integer countViews(@Param("week_mission_id") Integer week_mission_id);


    /**
     * 根据周任务id查询周任务
     *
     * @param week_mission_id week_mission_id
     * @return WeekMissionDTO
     */
    WeekMissionDTO selectById(@Param("week_mission_id") Integer week_mission_id);


    /**
     * 发布单个任务
     *
     * @param id id
     * @return int
     */
    Integer issue(@Param("week_mission_id") Integer id);


    //    ***************************************

    /**
     * 根据课程id 查询所有周任务的id和名称
     *
     * @param course_id course_id
     * @return WeekMission
     */
    List<WeekMission> selectByCourseId(@Param("course_id") Integer course_id);


    /**
     * 根据周id查周任务的id
     *
     * @param week_id week_id
     * @return int
     */
    Integer findWeekMissionIdByWeekId(@Param("week_id") Integer week_id);


    /**
     * 修改周任务名称
     *
     * @param week_mission_id   week_mission_id
     * @param week_mission_name week_mission_name
     * @return int
     */
    Integer updateName(
            @Param("week_mission_id") Integer week_mission_id,
            @Param("week_mission_name") String week_mission_name
    );


    /**
     * 修改周任务内容
     *
     * @param week_mission_id      week_mission_id
     * @param week_mission_content week_mission_content
     * @return int
     */
    Integer updateContent(
            @Param("week_mission_id") Integer week_mission_id,
            @Param("week_mission_content") String week_mission_content
    );
}