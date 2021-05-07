package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Evaluation;
import cn.hncj.assistant.mapper.EvaluationMapper;
import cn.hncj.assistant.service.EvaluationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    EvaluationMapper evaluationMapper;


    @Override
    public List<Evaluation> selectById(Integer id) {
        return evaluationMapper.selectList(new QueryWrapper<Evaluation>().eq("lesson_id", id));
    }
}
