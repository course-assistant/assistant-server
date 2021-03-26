package cn.hncj.assistant.service.impl;


import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.mapper.WeekMapper;
import cn.hncj.assistant.service.WeekService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class WeekServiceImpl implements WeekService {

    @Autowired
    WeekMapper weekMapper;

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
}
