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

}
