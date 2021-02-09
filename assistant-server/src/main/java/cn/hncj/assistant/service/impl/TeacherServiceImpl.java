package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.mapper.TeacherMapper;
import cn.hncj.assistant.pojo.Teacher;
import cn.hncj.assistant.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherMapper teacherMapper;

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> selectTeachers(Integer start, Integer size) {
        return teacherMapper.selectTeachers(start, size);
    }

    @Override
    public int insertTeacher(String id, String administrator_id, String name, Integer sex, String phone, String email) {
        // 判断字段合法性
        if (sex > 1 || sex < 0) {
            throw new IllegalArgumentException("参数不合法：sex应该为0或1");
        }

        // 执行
        try {
            return teacherMapper.insertTeacher(id, administrator_id, name, sex, phone, email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("执行数据库异常，请检查后台日志！");
        }
    }
}
