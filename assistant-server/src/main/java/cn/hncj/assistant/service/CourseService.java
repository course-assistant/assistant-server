package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.Course;

import java.util.Date;
import java.util.List;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface CourseService {

    /**
     * 根据教师id分页查询所有课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    List<Course> findCourseByTeacherId(String id, Integer page, Integer size);


    /**
     * 根据教师id分页查询正在教的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    List<Course> findStartedCourseByTeacherId(String id, Integer page, Integer size);


    /**
     * 根据教师id分页查询已结束的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    List<Course> findEndedCourseByTeacherId(String id, Integer page, Integer size);

    /**
     * 根据教师id分页查询已删除的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    List<Course> findDeletedCourseByTeacherId(String id, Integer page, Integer size);


    /**
     * 添加课程
     * @param teacher_id 教师id
     * @param name name
     * @param cover cover
     * @return int
     */
    Integer insertCourse(
            String teacher_id,
            String name,
            String cover
    );
}
