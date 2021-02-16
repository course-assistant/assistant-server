package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Class;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ClassMapper extends BaseMapper<Class> {

    /**
     * 修改班级名
     *
     * @param class_id   class_id
     * @param class_name class_name
     * @return int
     */
    Integer updateName(@Param("class_id") Integer class_id, @Param("class_name") String class_name);

}
