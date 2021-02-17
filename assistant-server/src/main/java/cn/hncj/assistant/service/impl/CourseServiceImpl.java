package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Course;
import cn.hncj.assistant.mapper.CourseMapper;
import cn.hncj.assistant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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


    /**
     * 修改课程
     *
     * @param map map
     * @return int
     */
    @Override
    public Integer updateCourse(Map<String, Object> map) {

        Integer course_id = (Integer) map.get("course_id");
        String teacher_id = (String) map.get("teacher_id");
        String course_name = (String) map.get("course_name");
        String course_cover = (String) map.get("course_cover");
        Integer course_status = (Integer) map.get("course_status");

        return courseMapper.updateCourse(course_id, teacher_id, course_name, course_cover, course_status);
    }

    /**
     * 添加课程
     *
     * @param teacher_id 教师id
     * @param name       name
     * @param cover      cover
     * @return int
     */
    @Override
    public Integer insertCourse(String teacher_id, String name, String cover) {
        Course course = new Course()
                .setTeacher_id(teacher_id)
                .setCourse_name(name)
                .setCourse_cover(cover)
                .setCourse_date(new Date());
        return courseMapper.insert(course);
    }
}
