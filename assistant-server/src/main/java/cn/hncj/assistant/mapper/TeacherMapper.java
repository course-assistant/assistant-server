package cn.hncj.assistant.mapper;

import cn.hncj.assistant.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> getTeachers();
}
