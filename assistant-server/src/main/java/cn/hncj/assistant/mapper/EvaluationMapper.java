package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EvaluationMapper extends BaseMapper<Evaluation> {


    Integer issue(String student_id, Integer evaluation_id);
}