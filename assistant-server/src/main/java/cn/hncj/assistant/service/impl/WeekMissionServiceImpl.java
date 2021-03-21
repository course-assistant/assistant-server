package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.WeekMission;
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

    /**
     * 根据id查询周任务
     *
     * @param id id
     * @return WeekMission
     */
    @Override
    public WeekMission selectById(Integer id) {
        return weekMissionMapper.selectById(id);
    }


    /**
     * 根据周id查询周任务
     *
     * @param id id
     * @return WeekMission
     */
    @Override
    public WeekMission selectByWeekId(Integer id) {
        QueryWrapper<WeekMission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("week_id", id);
        return weekMissionMapper.selectOne(queryWrapper);
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
}
