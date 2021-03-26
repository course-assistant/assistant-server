package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.WeekMissionDTO;
import cn.hncj.assistant.entity.WeekGoal;
import cn.hncj.assistant.entity.WeekMission;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.mapper.WeekGoalMapper;
import cn.hncj.assistant.mapper.WeekMissionMapper;
import cn.hncj.assistant.service.WeekMissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class WeekMissionServiceImpl implements WeekMissionService {

    @Autowired
    WeekMissionMapper weekMissionMapper;

    @Autowired
    WeekGoalMapper weekGoalMapper;


    /**
     * 根据周id查询周任务
     *
     * @param id id
     * @return WeekMission
     */
    @Override
    public List<WeekMissionDTO> selectByWeekId(Integer id) {
        List<WeekMissionDTO> weekMissionDTOList = weekMissionMapper.selectByWeekId(id);
        // 查询周任务的访问量
        for (WeekMissionDTO weekMissionDTO : weekMissionDTOList) {
            weekMissionDTO.setViews(weekMissionMapper.countViews(weekMissionDTO.getWeek_mission_id()));
        }
        return weekMissionDTOList;
    }



    /**
     * 根据id查询周任务
     *
     * @param id id
     * @return WeekMission
     */
    @Override
    public WeekMissionDTO selectById(Integer id) {
        WeekMissionDTO weekMissionDTO = weekMissionMapper.selectById(id);
        // 查询所有周目标
        QueryWrapper<WeekGoal> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("week_mission_id", id);
        weekMissionDTO.setWeek_goals(weekGoalMapper.selectList(queryWrapper));
        return weekMissionDTO;
    }


    /**
     * 添加周任务
     *
     * @param week_id week_id
     * @param name    name
     * @param type    type
     * @return int
     */
    @Override
    public Integer insert(Integer week_id, String name, Integer type) {
        if (type < 1 || type > 2){
            throw new ServerException("type只能为0，1");
        }
        WeekMission weekMission = new WeekMission()
                .setWeek_id(week_id)
                .setWeek_mission_name(name)
                .setWeek_mission_type(type)
                .setWeek_mission_status(2)
                .setWeek_mission_content("内容待编辑...");
        return weekMissionMapper.insert(weekMission);
    }


    /**
     * 删除周任务
     *
     * @param week_mission_id week_mission_id
     * @return int
     */
    @Override
    public Integer delete(Integer week_mission_id) {
        return weekMissionMapper.deleteById(week_mission_id);
    }


    /**
     * 修改周任务内容
     *
     * @param id      id
     * @param content content
     * @return int
     */
    @Override
    public Integer updateContent(Integer id, String content) {
        return weekMissionMapper.updateContent(id, content);
    }


    ///////////////////////////////


    /**
     * 根据课程id 查询所有周任务的id和名称
     *
     * @param id id
     * @return WeekMission
     */
    @Override
    public List<WeekMission> selectByCourseId(Integer id) {
        return weekMissionMapper.selectByCourseId(id);
    }


}
