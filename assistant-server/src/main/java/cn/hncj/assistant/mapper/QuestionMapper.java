package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionMapper extends BaseMapper<Question> {
}