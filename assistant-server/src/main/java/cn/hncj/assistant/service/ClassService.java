package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.Class;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface ClassService {

    /**
     * 根据课程id查询班级
     *
     * @param course_id course_id
     * @return class
     */
    List<Class> selectByCourseId(String course_id);


    /**
     * 根据班级id查询班级
     * @param classId classId
     * @return class
     */
    Class selectByClassId(Integer classId);


    /**
     * 查询班级的学生人数
     * @param class_id class_id
     * @return int
     */
    Integer countStudent(Integer class_id);


    /**
     * 添加班级
     *
     * @param course_id course_id
     * @param name      name
     * @return int
     */
    Integer insertClass(Integer course_id, String name);


    /**
     * 删除班级
     *
     * @param class_id class_id
     * @return int
     */
    Integer deleteClass(Integer class_id);


    /**
     * 学生选课
     *
     * @param student_id  student_id
     * @param invite_code invite_code
     * @return int
     */
    Integer selection(String student_id, String invite_code);


    /**
     * 教师给学生选课
     *
     * @param student_id student_id
     * @param class_id   class_id
     * @return int
     */
    Integer selectionByTeacher(String student_id, Integer class_id);


    /**
     * 将学生移出班级
     *
     * @param student_id student_id
     * @param class_id   class_id
     * @return int
     */
    Integer removeStudent(String student_id, Integer class_id);
}
