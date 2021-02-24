package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.TeacherDTO;
import cn.hncj.assistant.entity.Teacher;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.mapper.TeacherMapper;
import cn.hncj.assistant.service.TeacherService;
import cn.hncj.assistant.util.MD5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    TeacherMapper teacherMapper;

    @Autowired
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    /* 分页查询教师 */
    @Override
    public TeacherDTO selectTeacherByPage(Integer page, Integer size, String condition) {
        TeacherDTO teacherDTO = new TeacherDTO();
        // 条件为空
        if (condition == null) {
            teacherDTO.setTotal(teacherMapper.selectCount(null));
            // 实现根据页数分页查询
            teacherDTO.setTeachers(teacherMapper.selectTeachers(page * size, size, null));
            return teacherDTO;
        }
        // 条件不为空
        teacherDTO.setTeachers(teacherMapper.selectTeachers(page * size, size, condition));
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("teacher_id", condition);
        teacherDTO.setTotal(teacherMapper.selectCount(queryWrapper));
        return teacherDTO;
    }

    /**
     * 根据id查询教师
     *
     * @param id id
     * @return teacher
     */
    @Override
    public Teacher selectById(String id) {
        Teacher teacher = teacherMapper.selectById(id);
        if (teacher == null) {
            return null;
        }
        // 将密码和wx置空
        teacher.setTeacher_password(null).setTeacher_wx(null);
        return teacher;
    }

    @Override
    public Integer updateTeacher(Map<String, Object> map) {
        String teacher_id = (String) map.get("teacher_id");
        String teacher_password = (String) map.get("teacher_password");
        String teacher_avatar = (String) map.get("teacher_avatar");
        String teacher_phone = (String) map.get("teacher_phone");
        String teacher_email = (String) map.get("teacher_email");
        Integer teacher_status = (Integer) map.get("teacher_status");
        return teacherMapper.updateTeacher(teacher_id, teacher_password, teacher_avatar, teacher_phone, teacher_email, teacher_status);
    }


    @Override
    public Integer changePassword(String id, String oldPwd, String newPwd) {
        // 验证密码是否正确
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", id);
        queryWrapper.eq("teacher_password", MD5Util.MD5EncodeUpper(oldPwd));
        Integer count = teacherMapper.selectCount(queryWrapper);
        if (count < 1) {
            throw new ServerException("密码错误");
        }
        // 修改
        return teacherMapper.changePassword(id, MD5Util.MD5EncodeUpper(newPwd));
    }


    @Override
    public Integer deleteTeacherById(String id) {
        return teacherMapper.deleteById(id);
    }


    @Override
    public Integer cancel(String id, String password) {
        // 验证密码是否正确
        @SuppressWarnings("DuplicatedCode") QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", id);
        queryWrapper.eq("teacher_password", MD5Util.MD5EncodeUpper(password));
        Integer count = teacherMapper.selectCount(queryWrapper);
        if (count < 1) {
            throw new ServerException("密码错误");
        }
        // 修改
        return teacherMapper.deleteById(id);
    }


    @Override
    public int insertTeacher(String id, String administrator_id, String name, Integer sex, String phone, String email) throws ServerException {
        // 判断字段合法性
        if (sex != null && (sex > 1 || sex < 0)) {
            throw new ServerException("参数不合法：sex应该为0或1");
        }
        Teacher teacher = new Teacher();
        teacher.setTeacher_id(id)
                .setAdministrator_id(administrator_id)
                .setTeacher_name(name);
        if (sex != null) {
            teacher.setTeacher_sex(sex);
        }
        if (phone != null) {
            teacher.setTeacher_phone(phone);
        }
        if (email != null) {
            teacher.setTeacher_email(email);
        }
        return teacherMapper.insert(teacher);
    }
}
