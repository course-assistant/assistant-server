package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Evaluation;
import cn.hncj.assistant.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EvaluationMapper extends BaseMapper<Evaluation> {

}