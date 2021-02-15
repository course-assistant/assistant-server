package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@SuppressWarnings({"unused", "UnusedReturnValue"})
@Mapper
@Repository
public interface CourseMapper {

    /**
     * 分页查询正在进行的课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectStartedCourses(@Param("start") Integer start, @Param("size") Integer size);


    /**
     * 分页查询已结束的课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectEndedCourses(@Param("start") Integer start, @Param("size") Integer size);


    /**
     * 分页查询已删除的课程
     *
     * @param start start
     * @param size  size
     * @return list
     */
    List<Course> selectDeletedCourses(@Param("start") Integer start, @Param("size") Integer size);


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
            @Param("course_name") String course_name,
            @Param("course_cover") String course_cover,
            @Param("course_status") Integer course_status
    );

}
