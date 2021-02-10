package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.mapper.AdministratorMapper;
import cn.hncj.assistant.mapper.StudentMapper;
import cn.hncj.assistant.mapper.TeacherMapper;
import cn.hncj.assistant.service.LoginService;
import cn.hncj.assistant.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证用户传入的用户名和密码是否正确
 * 如果正确则返回token令牌
 */
@SuppressWarnings("DuplicatedCode")
@Service
public class LoginServiceImpl implements LoginService {

    AdministratorMapper administratorMapper;
    TeacherMapper teacherMapper;
    StudentMapper studentMapper;

    /* Setter */
    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
    /* Setter */


    /**
     * 仅验证管理员账号和密码
     *
     * @param administrator_id       管理员账号
     * @param administrator_password 管理员密码
     * @return boolean
     */
    @Override
    public boolean verifyAdministrator(String administrator_id, String administrator_password) {
        return administratorMapper.verifyAdministrator(administrator_id, administrator_password) > 0;
    }

    /**
     * 验证管理员账号和密码并分发token
     *
     * @param administrator_id       管理员账号
     * @param administrator_password 管理员密码
     * @return boolean
     */
    @Override
    public Map<String, Object> verifyAdministratorAndIssueToken(String administrator_id, String administrator_password) {
        HashMap<String, Object> map = new HashMap<>();
        // 验证结果
        boolean result = verifyAdministrator(administrator_id, administrator_password);
        // 添加验证结果
        if (result) {
            map.put("authorized", true);
            // 添加token
            HashMap<String, String> payload = new HashMap<>();
            payload.put("id", administrator_id);
            payload.put("role", RoleCheck.ADMIN);
            String token = JWTUtil.issueToken(payload);
            map.put("token", token);
            return map;
        }
        map.put("authorized", false);
        return map;
    }

    /**
     * 仅验证教师账号和密码
     *
     * @param teacher_id       管理员账号
     * @param teacher_password 管理员密码
     * @return boolean
     */
    @Override
    public boolean verifyTeacher(String teacher_id, String teacher_password) {
        return teacherMapper.verifyTeacher(teacher_id, teacher_password) > 0;
    }

    /**
     * 验证教师账号和密码并分发token
     *
     * @param teacher_id       管理员账号
     * @param teacher_password 管理员密码
     * @return boolean
     */
    @Override
    public Map<String, Object> verifyTeacherAndIssueToken(String teacher_id, String teacher_password) {
        HashMap<String, Object> map = new HashMap<>();
        // 验证结果
        boolean result = verifyTeacher(teacher_id, teacher_password);
        // 添加验证结果
        if (result) {
            map.put("authorized", true);
            // 添加token
            HashMap<String, String> payload = new HashMap<>();
            payload.put("id", teacher_id);
            payload.put("role", RoleCheck.TEACHER);
            String token = JWTUtil.issueToken(payload);
            map.put("token", token);
            return map;
        }
        map.put("authorized", false);
        return map;
    }

    /**
     * 仅验证学生账号和密码
     *
     * @param student_id       管理员账号
     * @param student_password 管理员密码
     * @return boolean
     */
    @Override
    public boolean verifyStudent(String student_id, String student_password) {
        return studentMapper.verifyStudent(student_id, student_password) > 0;
    }

    /**
     * 验证学生账号和密码并分发token
     *
     * @param student_id       管理员账号
     * @param student_password 管理员密码
     * @return boolean
     */
    @Override
    public Map<String, Object> verifyStudentAndIssueToken(String student_id, String student_password) {
        HashMap<String, Object> map = new HashMap<>();
        // 验证结果
        boolean result = verifyStudent(student_id, student_password);
        // 添加验证结果
        if (result) {
            map.put("authorized", true);
            // 添加token
            HashMap<String, String> payload = new HashMap<>();
            payload.put("id", student_id);
            payload.put("role", RoleCheck.STUDENT);
            String token = JWTUtil.issueToken(payload);
            map.put("token", token);
            return map;
        }
        map.put("authorized", false);
        return map;
    }
}
