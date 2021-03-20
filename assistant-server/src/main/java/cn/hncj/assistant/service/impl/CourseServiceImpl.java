package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.CourseDTO;
import cn.hncj.assistant.entity.Course;
import cn.hncj.assistant.entity.Period;
import cn.hncj.assistant.entity.Week;
import cn.hncj.assistant.entity.WeekMission;
import cn.hncj.assistant.mapper.CourseMapper;
import cn.hncj.assistant.mapper.PeriodMapper;
import cn.hncj.assistant.mapper.WeekMapper;
import cn.hncj.assistant.mapper.WeekMissionMapper;
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
        return courseMapper.findByCourseId(id);
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
     * 添加课程
     *
     * @param teacher_id 教师id
     * @param name       课程名
     * @param cover      封面
     * @param week       周数
     * @param oddPeriod  单周学时数
     * @param evenPeriod 双周学时数
     * @return int
     */
    @Transactional
    @Override
    public Integer insertCourse(String teacher_id, String name, String cover, Integer week, Integer oddPeriod, Integer evenPeriod) {
        /*
         * 1. 插入课程
         * 2. 获取插入的主键
         * 3. 给课程插入周数
         * 4. 在插入周的同时插入周的学时
         * 5. 给周插入周任务
         * */

        // 先插入一个课程
        Course course = new Course()
                .setTeacher_id(teacher_id)
                .setCourse_name(name)
                .setCourse_cover(cover)
                .setCourse_date(new Date());
        courseMapper.insert(course);
        // 获取刚刚插入的主键
        Integer courseId = course.getCourse_id();

        // 准备插入周数
        int periodNum = 1;
        for (int i = 1; i <= week; i++) {
            // 插入周
            Week newWeek = new Week()
                    .setCourse_id(courseId)
                    .setWeek_name(String.format("第%02d周", i));
            weekMapper.insert(newWeek);
            Integer weekId = newWeek.getWeek_id();

            // 给每个周插入学时
            // 判断当前周是单周还是双周
            int num = oddPeriod;
            if (i % 2 == 0) {
                num = evenPeriod;
            }
            for (int j = 0; j < num; j++) {
                Period period = new Period()
                        .setWeek_id(weekId)
                        .setPeriod_name(String.format("第%02d学时", periodNum))
                        .setPeriod_content("内容")
                        .setPeriod_type(1)
                        .setPeriod_status(1);
                periodMapper.insert(period);
                periodNum++;
            }

            // 插入周任务
            weekMissionMapper.insert(new WeekMission()
                    .setWeek_id(newWeek.getWeek_id())
                    .setWeek_mission_content("任务详情（待编辑）")
                    .setWeek_mission_name(newWeek.getWeek_name() + " 任务")
                    .setWeek_mission_status(1)
            );
        }
        return null;
    }


}
