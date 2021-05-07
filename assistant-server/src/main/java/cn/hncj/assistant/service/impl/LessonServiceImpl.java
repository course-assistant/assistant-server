package cn.hncj.assistant.service.impl;


import cn.hncj.assistant.dto.LessonDTO;
import cn.hncj.assistant.entity.Lesson;
import cn.hncj.assistant.mapper.LessonMapper;
import cn.hncj.assistant.mapper.WeekMapper;
import cn.hncj.assistant.service.LessonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
     * 根据课程id查询课
     *
     * @param id 课程id
     * @return WeekLessonDTO
     */
    @Override
    public List<LessonDTO> selectLessons(Integer id) {
        // 先查询出Lesson
        List<LessonDTO> lessonDTOS = lessonMapper.selectLessons(id);
        // 再依次查询平均分
        for (LessonDTO lessonDTO : lessonDTOS) {
            Map<String, Object> map = lessonMapper.selectAvgEvaluation(lessonDTO.getLesson_id());
            System.out.println("map " + map);
            if (map == null || map.get("degree") == null || map.get("quality") == null) {
                lessonDTO.setDegree("0.0");
                lessonDTO.setQuality("0.0");
                continue;
            }
            // 暂时不四舍五入，用这个简单的方法
            lessonDTO.setDegree(String.valueOf(((BigDecimal) map.get("degree")).floatValue()).substring(0, 3));
            lessonDTO.setQuality(String.valueOf(((BigDecimal) map.get("quality")).floatValue()).substring(0, 3));
        }
        return lessonDTOS;
    }

    @Override
    public Lesson selectByLessonId(Integer id) {
        return lessonMapper.selectById(id);
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

    /**
     * 修改课时内容
     *
     * @param id      id
     * @param content content
     * @return int
     */
    @Override
    public Integer updateLesson(Integer id, String content) {
        return lessonMapper.updateLesson(id, content);
    }
}
