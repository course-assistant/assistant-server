package cn.hncj.assistant;

import cn.hncj.assistant.entity.Course;
import cn.hncj.assistant.entity.User;
import cn.hncj.assistant.mapper.*;
import cn.hncj.assistant.service.CourseService;
import cn.hncj.assistant.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Autowired
    ClassMapper classMapper;

    @Test
    void testMybatis() {
        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testMapper() {
//        List<Class> classes = classMapper.selectList(null);
//        for (Class aClass : classes) {
//            System.out.println(aClass);
//        }
//        Class aClass = classMapper.selectById(1);
//
//        System.out.println(aClass);

//        classMapper.insert(new Class(3, 1, "三班"));

//        Integer integer = classMapper.selectCount(null);
//        System.out.println(integer);

        classMapper.updateName(1, "一班");
        classMapper.updateName(2, "二班");

    }

    @Test
    void testService() {
        List<Course> courses = courseService.findStartedCourseByTeacherId("888888888", 0, 3);
        for (Course course : courses) {
            System.out.println(course);
        }
    }

}
