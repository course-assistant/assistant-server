package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.CourseDTO;
import cn.hncj.assistant.entity.Class;
import cn.hncj.assistant.entity.Course;
import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.mapper.*;
import cn.hncj.assistant.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    WeekMapper weekMapper;

    @Autowired
    PeriodMapper periodMapper;

    @Autowired
    WeekMissionMapper weekMissionMapper;

    @Autowired
    ClassMapper classMapper;


    /**
     * 根据教师id分页查询课程
     *
     * @param id     教师id
     * @param page   page
     * @param size   size
     * @param status status
     * @return course
     */
    @Override
    public List<CourseDTO> selectCourseByTeacherId(String id, Integer page, Integer size, Integer status) {
        // 查询所有
        if (status == null) {
            return courseMapper.selectCourseByTeacherId(id, page * size, size, 0);
        }
        if (status < 0 || status > 3) {
            throw new ServerException("status只能为0 1 2 3");
        }
        return courseMapper.selectCourseByTeacherId(id, page * size, size, status);
    }


    /**
     * 根据学生id分页查询课程
     *
     * @param id     学生id
     * @param page   page
     * @param size   size
     * @param status status
     * @return course
     */
    @Override
    public List<CourseDTO> selectCourseByStudentId(String id, Integer page, Integer size, Integer status) {
        // 查询所有
        if (status == null) {
            return courseMapper.selectCourseByStudentId(id, page * size, size, 0);
        }
        if (status < 0 || status > 3) {
            throw new ServerException("status只能为0 1 2 3");
        }
        return courseMapper.selectCourseByStudentId(id, page * size, size, status);
    }


    /**
     * 根据课程id查询课程
     *
     * @param id id
     * @return courseDTO
     */
    @Override
    public CourseDTO findByCourseId(Integer id) {
        CourseDTO courseDTO = courseMapper.findByCourseId(id);
        if (courseDTO == null) {
            throw new ServerException("该课程不存在");
        }
        return courseDTO;
    }


    /**
     * 手动添加课程
     *
     * @param teacher_id  教师id
     * @param name        课程名
     * @param cover       库课程封面
     * @param week        课程的周数
     * @return int
     */
    @Override
    @Transactional
    public Integer insertCourse(String teacher_id, String name, String cover, Integer week) {
        /*
         * 1.创建课程
         * 2.添加课程的周
         * 3.添加默认班级
         */

        // 1 创建一个课程
        Course course = new Course()
                .setTeacher_id(teacher_id)
                .setCourse_name(name)
                .setCourse_cover(cover)
                .setCourse_status(1)
                .setCourse_date(new Date());
        courseMapper.insert(course);

        // 2 创建课程的周
        for (int i = 1; i <= week; i++) {
            Week w = new Week()
                    .setCourse_id(course.getCourse_id())
                    .setWeek_name(String.format("第%02d周", i))
                    .setWeek_index(i)
                    .setWeek_status(2);
            weekMapper.insert(w);
        }

        // 3 添加一个默认班级
        Class aClass = new Class()
                .setCourse_id(course.getCourse_id())
                .setClass_name("默认班级");
        classMapper.insert(aClass);

        return 1;
    }


    /**
     * 删除课程
     *
     * @param id id
     * @return int
     */
    @Override
    public Integer deleteCourse(Integer id) {
        return courseMapper.deleteById(id);
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


}
