package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.StudentDTO;
import cn.hncj.assistant.mapper.StudentMapper;
import cn.hncj.assistant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }


    @Override
    public StudentDTO selectStudentByPage(Integer page, Integer size) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setTotal(studentMapper.countStudent());
        studentDTO.setStudents(studentMapper.selectStudents(page * size, size));
        return studentDTO;
    }

    @Override
    public Integer updateStudent(Map<String, Object> map) {
        String student_id = (String) map.get("student_id");
        String student_password = (String) map.get("student_password");
        String student_avatar = (String) map.get("student_avatar");
        String student_phone = (String) map.get("student_phone");
        String student_email = (String) map.get("student_email");
        Integer student_status = (Integer) map.get("student_status");
        return studentMapper.updateStudent(student_id, student_password, student_avatar, student_phone, student_email, student_status);
    }

    @Override
    public Integer deleteStudentById(String id) {
        return studentMapper.deleteStudentById(id);
    }
}
