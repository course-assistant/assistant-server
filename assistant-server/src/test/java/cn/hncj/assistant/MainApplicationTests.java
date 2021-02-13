package cn.hncj.assistant;

import cn.hncj.assistant.mapper.TeacherMapper;
import cn.hncj.assistant.mapper.UserMapper;
import cn.hncj.assistant.entity.User;
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

}
