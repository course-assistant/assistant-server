package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.Course;

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
    public List<Course> findCourseByTeacherId(String id, Integer page, Integer size);


    /**
     * 根据教师id分页查询正在教的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    public List<Course> findStartedCourseByTeacherId(String id, Integer page, Integer size);


    /**
     * 根据教师id分页查询已结束的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    public List<Course> findEndedCourseByTeacherId(String id, Integer page, Integer size);

    /**
     * 根据教师id分页查询已删除的课程
     *
     * @param id   id
     * @param page page
     * @param size size
     * @return course
     */
    public List<Course> findDeletedCourseByTeacherId(String id, Integer page, Integer size);

}
