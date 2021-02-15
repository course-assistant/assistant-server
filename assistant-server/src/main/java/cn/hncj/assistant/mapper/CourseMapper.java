package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@SuppressWarnings({"unused", "UnusedReturnValue"})
@Mapper
@Repository
public interface CourseMapper {

    /**
     * 分页查询使所有课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectCourses(
            @Param("teacher_id") String teacher_id,
            @Param("start") Integer start,
            @Param("size") Integer size
    );


    /**
     * 分页查询正在进行的课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectStartedCourses(
            @Param("teacher_id") String teacher_id,
            @Param("start") Integer start,
            @Param("size") Integer size
    );


    /**
     * 分页查询已结束的课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectEndedCourses(
            @Param("teacher_id") String teacher_id,
            @Param("start") Integer start,
            @Param("size") Integer size
    );


    /**
     * 分页查询已删除的课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectDeletedCourses(
            @Param("teacher_id") String teacher_id,
            @Param("start") Integer start,
            @Param("size") Integer size
    );


    /**
     * 删除课程
     *
     * @param course_id id
     * @return int
     */
    Integer deleteCourseById(@Param("course_id") Integer course_id);


    /**
     * 修改课程
     * @param course_id id
     * @param course_name name
     * @param course_cover cover
     * @param course_status status
     * @return int
     */
    Integer updateCourse(
            @Param("course_id") Integer course_id,
            @Param("teacher_id") String teacher_id,
            @Param("course_name") String course_name,
            @Param("course_cover") String course_cover,
            @Param("course_status") Integer course_status
    );


    /**
     * 添加课程
     * @param teacher_id 所属教师id
     * @param course_name name
     * @param course_date date
     * @param course_cover cover
     * @return int
     */
    Integer insertCourse(
            String teacher_id,
            String course_name,
            Date course_date,
            String course_cover
    );

}
