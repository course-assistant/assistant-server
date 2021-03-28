package cn.hncj.assistant.service.impl;


import cn.hncj.assistant.dto.WeekLessonDTO;
import cn.hncj.assistant.entity.Lesson;
import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.mapper.LessonMapper;
import cn.hncj.assistant.mapper.WeekMapper;
import cn.hncj.assistant.service.LessonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class LessonServiceImpl
        extends ServiceImpl<LessonMapper, Lesson>
        implements LessonService {

    @Autowired
    WeekMapper weekMapper;

    @Autowired
    LessonMapper lessonMapper;

    /**
     * 根据课程id查询周和课
     *
     * @param id 课程id
     * @return WeekLessonDTO
     */
    @Override
    public List<WeekLessonDTO> selectWeekLesson(Integer id) {
        ArrayList<WeekLessonDTO> list = new ArrayList<>();

        // 查询所有周
        QueryWrapper<Week> queryWrapper = new QueryWrapper<Week>().eq("course_id", id);
        List<Week> weeks = weekMapper.selectList(queryWrapper);

        // 根据周查询周里的课程
        for (Week week : weeks) {
            WeekLessonDTO weekLessonDTO = new WeekLessonDTO();
            weekLessonDTO.setWeek_id(week.getWeek_id()).setWeek_name(week.getWeek_name());
            // 查询里面的课程
            List<Lesson> lessons = lessonMapper.selectList(new QueryWrapper<Lesson>().eq("week_id", week.getWeek_id()));
            weekLessonDTO.setLessons(lessons);
            list.add(weekLessonDTO);
        }

        return list;
    }
}
