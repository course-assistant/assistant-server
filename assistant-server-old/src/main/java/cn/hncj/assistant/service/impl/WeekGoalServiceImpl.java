package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.WeekGoal;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.mapper.WeekGoalMapper;
import cn.hncj.assistant.service.WeekGoalService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class WeekGoalServiceImpl implements WeekGoalService {

    @Autowired
    WeekGoalMapper weekGoalMapper;


    /**
     * 添加周目标
     *
     * @param week_mission_id week_mission_id
     * @param title           title
     * @param content         content
     * @return int
     */
    @Override
    public Integer insert(Integer week_mission_id, String title, String content) {
        WeekGoal weekGoal = new WeekGoal()
                .setWeek_mission_id(week_mission_id)
                .setWeek_goal_title(title)
                .setWeek_goal_content(content);
        return weekGoalMapper.insert(weekGoal);
    }


    /**
     * 删除周目标
     *
     * @param id id
     * @return int
     */
    @Override
    public Integer delete(Integer id) {
        return weekGoalMapper.deleteById(id);
    }


    /**
     * 修改周目标
     *
     * @param id      id
     * @param title   title
     * @param content content
     * @return int
     */
    @Override
    public Integer update(Integer id, String title, String content) {
        if (title == null && content == null) {
            throw new ServerException("请至少传入一个参数");
        }
        return weekGoalMapper.updateWeekGoal(id, title, content);
    }


    //////////////////////////////////////////


    /**
     * 根据周id查询周目标
     *
     * @param id 周id
     * @return weekGoal
     */
    @Override
    public List<WeekGoal> selectByWeekId(Integer id) {
        QueryWrapper<WeekGoal> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("week_id", id);
        return weekGoalMapper.selectList(queryWrapper);
    }




}
