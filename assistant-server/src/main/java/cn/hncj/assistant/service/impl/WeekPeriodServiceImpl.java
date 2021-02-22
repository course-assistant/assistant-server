package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.WeekPeriodDTO;
import cn.hncj.assistant.entity.Period;
import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.mapper.PeriodMapper;
import cn.hncj.assistant.mapper.WeekMapper;
import cn.hncj.assistant.service.WeekPeriodService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class WeekPeriodServiceImpl implements WeekPeriodService {

    @Autowired
    WeekMapper weekMapper;

    @Autowired
    PeriodMapper periodMapper;

    /**
     * 根据课程id查询周和学时
     *
     * @param courseId id
     * @return week period
     */
    @Override
    public List<WeekPeriodDTO> selectWeekPeriod(Integer courseId) {
        // 根据courseId查询所有周
        // 再根据每个周的id 查询学时
        QueryWrapper<Week> weekQueryWrapper = new QueryWrapper<>();
        weekQueryWrapper.eq("course_id", courseId);
        List<Week> weeks = weekMapper.selectList(weekQueryWrapper);

        List<WeekPeriodDTO> list = new ArrayList<>();

        for (Week week : weeks) {
            // 查询学时
            QueryWrapper<Period> periodQueryWrapper = new QueryWrapper<>();
            periodQueryWrapper.eq("week_id", week.getWeek_id());
            List<Period> periods = periodMapper.selectList(periodQueryWrapper);
            // 添加进list
            WeekPeriodDTO weekPeriodDTO = new WeekPeriodDTO()
                    .setWeek_id(week.getWeek_id())
                    .setWeek_name(week.getWeek_name())
                    .setPeriods(periods);
            list.add(weekPeriodDTO);
        }
        return list;
    }

    /**
     * 给课程添加一个周
     *
     * @param courseId courseId
     * @param name     name
     * @return int
     */
    @Override
    public Integer addWeek(Integer courseId, String name) {
        Week week = new Week().setCourse_id(courseId).setWeek_name(name);
        return weekMapper.insert(week);
    }

    /**
     * 修改学时
     *
     * @param id     学时id
     * @param name   新名字
     * @param type   新type
     * @param status 新status
     * @return int
     */
    @Override
    public Integer updatePeriod(Integer id, String name, Integer type, Integer status) {
        return periodMapper.updatePeriod(id, name, type, status);
    }

    /**
     * 修改周
     *
     * @param id   id
     * @param name name
     * @return int
     */
    @Override
    public Integer updateWeek(Integer id, String name) {
        return weekMapper.updateWeek(id, name);
    }

    /**
     * 删除学时
     *
     * @param id id
     * @return int
     */
    @Override
    public Integer deletePeriodById(Integer id) {
        return periodMapper.deleteById(id);
    }

    /**
     * 删除周
     *
     * @param id id
     * @return int
     */
    @Override
    public Integer deleteWeekById(Integer id) {
        return weekMapper.deleteById(id);
    }
}
