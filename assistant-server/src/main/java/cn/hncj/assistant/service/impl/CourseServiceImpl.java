package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Course;
import cn.hncj.assistant.mapper.CourseMapper;
import cn.hncj.assistant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    CourseMapper courseMapper;

    @Autowired
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    /**
     * 根据教师id分页查询所有课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    @Override
    public List<Course> findCourseByTeacherId(String id, Integer page, Integer size) {
        return courseMapper.selectCourses(id, page * size, size);
    }

    /**
     * 根据教师id分页查询正在教的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    @Override
    public List<Course> findStartedCourseByTeacherId(String id, Integer page, Integer size) {
        return courseMapper.selectStartedCourses(id, page * size, size);
    }

    /**
     * 根据教师id分页查询已结束的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    @Override
    public List<Course> findEndedCourseByTeacherId(String id, Integer page, Integer size) {
        return courseMapper.selectEndedCourses(id, page * size, size);
    }

    /**
     * 根据教师id分页查询已删除的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    @Override
    public List<Course> findDeletedCourseByTeacherId(String id, Integer page, Integer size) {
        return courseMapper.selectDeletedCourses(id, page * size, size);
    }
}
