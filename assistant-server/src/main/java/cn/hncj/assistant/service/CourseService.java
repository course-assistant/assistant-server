package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.CourseDTO;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"UnusedReturnValue", "unused"})
public interface CourseService {

    /**
     * 根据教师id分页查询课程
     *
     * @param id     教师id
     * @param page   page
     * @param size   size
     * @param status status
     * @return course
     */
    List<CourseDTO> selectCourseByTeacherId(String id, Integer page, Integer size, Integer status);


    /**
     * 根据学生id分页查询课程
     *
     * @param id     学生id
     * @param page   page
     * @param size   size
     * @param status status
     * @return course
     */
    List<CourseDTO> selectCourseByStudentId(String id, Integer page, Integer size, Integer status);


    /**
     * 根据课程id查询课程
     * @param id id
     * @return courseDTO
     */
    CourseDTO findByCourseId(Integer id);


    /**
     * 修改课程
     *
     * @param map map
     * @return int
     */
    Integer updateCourse(Map<String, Object> map);


//    /**
//     * 添加课程
//     *
//     * @param teacher_id 教师id
//     * @param name       name
//     * @param cover      cover
//     * @return int
//     */
//    Integer insertCourse(
//            String teacher_id,
//            String name,
//            String cover
//    );


    /**
     * 删除课程
     *
     * @param id id
     * @return int
     */
    Integer deleteCourse(Integer id);


    /**
     * 手动添加课程
     *
     * @param teacher_id  教师id
     * @param name        课程名
     * @param cover       库课程封面
     * @param week        课程的周数
     * @return int
     */
    Integer insertCourse(
            String teacher_id,
            String name,
            String cover,
            Integer week
    );

}
