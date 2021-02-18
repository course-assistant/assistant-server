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
        classMapper.updateName(1, "一班");
        classMapper.updateName(2, "二班");
    }

    @Test
    void testService() {

    }

}
