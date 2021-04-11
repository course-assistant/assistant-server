package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.CourseDTO;
import cn.hncj.assistant.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@SuppressWarnings({"unused", "UnusedReturnValue"})
@Mapper
@Repository
public interface CourseMapper extends BaseMapper<Course> {


    /**
     * 分页查询使所有课程
     *
     * @param start  start
     * @param size   size
     * @param status status
     * @return list
     */
    List<CourseDTO> selectCourseByTeacherId(
            @Param("teacher_id") String teacher_id,
            @Param("start") Integer start,
            @Param("size") Integer size,
            @Param("status") Integer status
    );


    /**
     * 分页查询使所有课程
     *
     * @param start  start
     * @param size   size
     * @param status status
     * @return list
     */
    List<CourseDTO> selectCourseByStudentId(
            @Param("student_id") String student_id,
            @Param("start") Integer start,
            @Param("size") Integer size,
            @Param("status") Integer status
    );


    /**
     * 根据课程id查询课程
     *
     * @param course_id course_id
     * @return courseDTO
     */
    CourseDTO findByCourseId(@Param("course_id") Integer course_id);


    /**
     * 修改课程
     *
     * @param course_id     id
     * @param course_name   name
     * @param course_cover  cover
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
     * 查询课程的学生人数
     *
     * @param course_id course_id
     * @return int
     */
    Integer countStudent(@Param("course_id") Integer course_id);

}
