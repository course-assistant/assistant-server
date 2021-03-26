package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.WeekGoal;
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



    ////////////

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


//    /**
//     * 添加周目标
//     *
//     * @param week_id week_id
//     * @param title   title
//     * @param content content
//     * @return int
//     */
//    @Override
//    public Integer insert(Integer week_id, String title, String content) {
//        WeekGoal weekGoal = new WeekGoal()
//                .setWeek_id(week_id)
//                .setWeek_goal_title(title)
//                .setWeek_goal_content(content);
//        return weekGoalMapper.insert(weekGoal);
//    }


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
}
