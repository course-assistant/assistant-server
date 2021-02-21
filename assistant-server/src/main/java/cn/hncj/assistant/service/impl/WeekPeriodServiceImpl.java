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
}
