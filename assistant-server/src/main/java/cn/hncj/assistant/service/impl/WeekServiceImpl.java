package cn.hncj.assistant.service.impl;


import cn.hncj.assistant.dto.WeekDTO;
import cn.hncj.assistant.dto.WeekInfoDTO;
import cn.hncj.assistant.dto.WeekMissionDTO2;
import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.entity.WeekGoal;
import cn.hncj.assistant.mapper.*;
import cn.hncj.assistant.service.WeekService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class WeekServiceImpl
        extends ServiceImpl<WeekMapper, Week>
        implements WeekService {

    @Autowired
    WeekMapper weekMapper;

    @Autowired
    WeekMissionMapper weekMissionMapper;

    @Autowired
    WeekGoalMapper weekGoalMapper;

    @Autowired
    CourseMapper courseMapper;

    /**
     * 根据课程id查询所有周
     *
     * @param course_id course_id
     * @return Week
     */
    @Override
    public List<Week> selectWeek(Integer course_id) {
        QueryWrapper<Week> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", course_id);
        return weekMapper.selectList(wrapper);
    }


    /**
     * 根据周id查询周
     *
     * @param week_id week_id
     * @return week
     */
    @Override
    public Week selectById(Integer week_id) {
        return weekMapper.selectById(week_id);
    }


    /**
     * 根据周任务id查询周任务
     *
     * @param id id
     * @return WeekMissionDTO2
     */
    @Override
    public WeekMissionDTO2 selectMissionById(Integer id) {
        WeekMissionDTO2 weekMissionDTO2 = weekMapper.selectMissionById(id);
        weekMissionDTO2.setWeek_goals(weekGoalMapper.selectList(new QueryWrapper<WeekGoal>().eq("week_mission_id", weekMissionDTO2.getWeek_mission_id())));
        return weekMissionDTO2;
    }


    /**
     * 查询周信息
     *
     * @param course_id course_id
     * @return WeekInfoDTO
     */
    @Override
    public WeekInfoDTO select(Integer course_id) {
        WeekInfoDTO weekInfoDTO = new WeekInfoDTO();
        // 根据课程id查询所有的周
        List<WeekDTO> weekDTOS = weekMapper.selectWeekDTO(course_id);
        int publishedWeek = 0;

        // 查询所有周的周任务
        for (WeekDTO weekDTO : weekDTOS) {
            if (weekDTO.getWeek_status() == 1) {
                publishedWeek++;
            }
            // 查询任务
            List<WeekMissionDTO2> weekMissionDTO2s = weekMapper.selectWeekMissionDTO2(weekDTO.getWeek_id());
            for (WeekMissionDTO2 mission : weekMissionDTO2s) {
                // 查询完成人数
                mission.setOk_num(weekMapper.countMissionViews(mission.getWeek_mission_id()));
                // 查询目标
                mission.setWeek_goals(weekGoalMapper.selectList(new QueryWrapper<WeekGoal>().eq("week_mission_id", mission.getWeek_mission_id())));
            }
            weekDTO.setMissions(weekMissionDTO2s);
        }
        weekInfoDTO.setWeeks(weekDTOS);

        weekInfoDTO.setWeek_published_num(publishedWeek);
        weekInfoDTO.setWeek_total_num(weekDTOS.size());

        // 计算所有学生
        weekInfoDTO.setStudent_total_num(courseMapper.countStudent(course_id));

        // 计算完成所有任务的人数
        weekInfoDTO.setStudent_ok_num(countFinishedAllWeekStudent(course_id));

        return weekInfoDTO;
    }


    /**
     * 发布任务
     *
     * @param mission_id mission_id
     * @return int
     */
    @Override
    public Integer issueMission(Integer mission_id) {
        return weekMissionMapper.issue(mission_id);
    }


    /**
     * 删除任务
     *
     * @param mission_id mission_id
     * @return int
     */
    @Override
    public Integer deleteMission(Integer mission_id) {
        return weekMissionMapper.deleteById(mission_id);
    }


    /**
     * 学生查看任务
     *
     * @param student_id student_id
     * @param mission_id mission_id
     * @return int
     */
    @Override
    public Integer viewMission(String student_id, Integer mission_id) {
        Integer n;
        try {
            n = weekMapper.viewMission(student_id, mission_id);
        } catch (Exception e) {
            return 0;
        }
        return n;
    }


    @Autowired
    StudentMapper studentMapper;

    public int countFinishedAllWeekStudent(Integer course_id) {
        int num = 0;
        // 查询这门课的所有学生id
        List<String> studentIds = studentMapper.selectIdByCourseId(course_id);

        // 查询这门课的所有任务
        List<Integer> missionIds = weekMissionMapper.selectWeekMissionIdsByCourseId(course_id);

//        System.out.println(Arrays.toString(missionIds.toArray()));

        // 记录所有任务数
        int missions = missionIds.size();

        // 依次检查所有学生，看看有没有完成任务，完成的+1
        for (String studentId : studentIds) {
            // 记录该学生完成的任务
            int ms = 0;
            // 遍历所有学生
            for (Integer missionId : missionIds) {
                // 遍历所有任务
                if (weekMissionMapper.viewsMission(studentId, missionId) > 0) {
                    ms++;
                }
            }
            if (ms == missions)
                num++;
        }
        return num;
    }


}
