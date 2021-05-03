package cn.hncj.assistant.service.impl;


import cn.hncj.assistant.entity.Lesson;
import cn.hncj.assistant.mapper.LessonMapper;
import cn.hncj.assistant.mapper.WeekMapper;
import cn.hncj.assistant.service.LessonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Lesson> selectLessons(Integer id) {
        QueryWrapper<Lesson> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id", id);
        return lessonMapper.selectList(queryWrapper);
    }

    /**
     * 添加课时
     *
     * @param id      id
     * @param name    name
     * @param content content
     * @return int
     */
    @Override
    public Integer insert(Integer id, String name, String content) {
        Lesson lesson = new Lesson()
                .setCourse_id(id)
                .setLesson_name(name)
                .setLesson_content(content)
                .setLesson_status(2);
        return lessonMapper.insert(lesson);
    }
}
