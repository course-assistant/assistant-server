package cn.hncj.assistant;

import cn.hncj.assistant.entity.User;
import cn.hncj.assistant.mapper.TeacherMapper;
import cn.hncj.assistant.mapper.UserMapper;
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
    TeacherService teacherService;

    @Test
    void testMybatis() {
        List<User> users = userMapper.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    void testMapper() {

    }

    @Test
    void testService() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacher_id", "153169549");
        map.put("teacher_phone", "11122233344");
        map.put("teacher_status", 1);

        teacherService.updateTeacher(map);
    }

}
