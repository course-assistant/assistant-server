package cn.hncj.assistant.service;


import cn.hncj.assistant.entity.Lesson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LessonService extends IService<Lesson> {


    /**
     * 根据课程id查询课时
     *
     * @param id 课程id
     * @return WeekLessonDTO
     */
    List<Lesson> selectLessons(Integer id);


    /**
     * 添加课时
     *
     * @param id      id
     * @param name    name
     * @param content content
     * @return int
     */
    Integer insert(Integer id, String name, String content);

}
