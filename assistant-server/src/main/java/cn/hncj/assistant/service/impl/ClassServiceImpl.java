package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Class;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.mapper.ClassMapper;
import cn.hncj.assistant.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassMapper classMapper;

    /**
     * 根据课程id查询班级
     *
     * @param course_id course_id
     * @return class
     */
    @Override
    public List<Class> selectByCourseId(String course_id) {
        return classMapper.selectByCourseId(course_id);
    }


    /**
     * 根据班级id查询班级
     *
     * @param classId classId
     * @return class
     */
    @Override
    public Class selectByClassId(Integer classId) {
        Class aClass = classMapper.selectById(classId);
        if (aClass == null) {
            throw new ServerException("不存在该班级");
        }
        return aClass;
    }


    /**
     * 查询班级的学生人数
     *
     * @param class_id class_id
     * @return int
     */
    @Override
    public Integer countStudent(Integer class_id) {
        return classMapper.countStudent(class_id);
    }


    /**
     * 添加班级
     *
     * @param course_id course_id
     * @param name      name
     * @return int
     */
    @Override
    public Integer insertClass(Integer course_id, String name) {
        Class entity = new Class();
        entity.setCourse_id(course_id).setClass_name(name);
        return classMapper.insert(entity);
    }


    /**
     * 删除班级
     *
     * @param class_id class_id
     * @return int
     */
    @Override
    public Integer deleteClass(Integer class_id) {
        return classMapper.deleteById(class_id);
    }


    /**
     * 学生选课
     *
     * @param student_id  student_id
     * @param invite_code invite_code
     * @return int
     */
    @Override
    public Integer selection(String student_id, String invite_code) {
        int code;
        // 根据邀请码解析出课程id
        try {
            code = Integer.parseInt(invite_code);
            code = code ^ 0x1111;
            return classMapper.selection(student_id, code);
        } catch (Exception e) {
            throw new ServerException("邀请码错误");
        }
    }

}
