package cn.hncj.assistant.service;


import cn.hncj.assistant.dto.WeekLessonDTO;
import cn.hncj.assistant.entity.Lesson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface LessonService extends IService<Lesson> {


    /**
     * 根据课程id查询周和课
     *
     * @param id kcid
     * @return WeekLessonDTO
     */
    List<WeekLessonDTO> selectWeekLesson(Integer id);

}
