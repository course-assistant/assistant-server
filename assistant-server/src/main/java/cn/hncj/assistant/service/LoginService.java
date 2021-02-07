package cn.hncj.assistant.service;

import java.util.Map;

public interface LoginService {

    /**
     * 仅验证管理员账号和密码
     *
     * @param administrator_id       管理员账号
     * @param administrator_password 管理员密码
     * @return boolean
     */
    boolean verifyAdministrator(String administrator_id, String administrator_password);

    /**
     * 验证管理员账号和密码并分发token
     *
     * @param administrator_id       管理员账号
     * @param administrator_password 管理员密码
     * @return boolean
     */
    Map<String, Object> verifyAdministratorAndIssueToken(String administrator_id, String administrator_password);


    /**
     * 仅验证教师账号和密码
     *
     * @param teacher_id       管理员账号
     * @param teacher_password 管理员密码
     * @return boolean
     */
    boolean verifyTeacher(String teacher_id, String teacher_password);

    /**
     * 验证教师账号和密码并分发token
     *
     * @param teacher_id       管理员账号
     * @param teacher_password 管理员密码
     * @return boolean
     */
    Map<String, Object> verifyTeacherAndIssueToken(String teacher_id, String teacher_password);

    /**
     * 仅验证学生账号和密码
     *
     * @param student_id       管理员账号
     * @param student_password 管理员密码
     * @return boolean
     */
    boolean verifyStudent(String student_id, String student_password);

    /**
     * 验证学生账号和密码并分发token
     *
     * @param student_id       管理员账号
     * @param student_password 管理员密码
     * @return boolean
     */
    Map<String, Object> verifyStudentAndIssueToken(String student_id, String student_password);
}
