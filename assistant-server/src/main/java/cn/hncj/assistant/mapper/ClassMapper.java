package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@SuppressWarnings("UnusedReturnValue")
@Mapper
@Repository
public interface ClassMapper extends BaseMapper<Class> {

    /**
     * 根据课程id查询班级
     *
     * @param course_id course_id
     * @return class
     */
    List<Class> selectByCourseId(@Param("course_id") String course_id);


    /**
     * 查询班级的学生人数
     * @param class_id class_id
     * @return int
     */
    Integer countStudent(@Param("class_id") Integer class_id);


    /**
     * 修改班级名
     *
     * @param class_id   class_id
     * @param class_name class_name
     * @return int
     */
    Integer updateName(@Param("class_id") Integer class_id, @Param("class_name") String class_name);


    /**
     * 学生选课
     *
     * @param student_id student_id
     * @param class_id   class_id
     * @return int
     */
    Integer selection(@Param("student_id") String student_id, @Param("class_id") Integer class_id);


    /**
     * 将学生移出班级
     *
     * @param student_id student_id
     * @param class_id   class_id
     * @return int
     */
    Integer removeStudent(String student_id, Integer class_id);
}
