package cn.hncj.assistant;

import cn.hncj.assistant.entity.Course;
import cn.hncj.assistant.entity.User;
import cn.hncj.assistant.mapper.CourseMapper;
import cn.hncj.assistant.mapper.StudentMapper;
import cn.hncj.assistant.mapper.TeacherMapper;
import cn.hncj.assistant.mapper.UserMapper;
import cn.hncj.assistant.service.CourseService;
import cn.hncj.assistant.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MainApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CourseService courseService;

    @Test
    void testMybatis() {
        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testMapper() {

        courseMapper.updateCourse(3,
                "测测测试",
                "cover",
                1);
    }

    @Test
    void testService() {
        List<Course> courses = courseService.findStartedCourseByTeacherId("888888888", 0, 3);
        for (Course course : courses) {
            System.out.println(course);
        }
    }

}
