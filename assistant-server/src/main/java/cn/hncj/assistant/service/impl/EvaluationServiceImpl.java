package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Evaluation;
import cn.hncj.assistant.mapper.EvaluationMapper;
import cn.hncj.assistant.service.EvaluationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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


    @Override
    @Transactional
    public Integer issue(Integer lesson_id, String student_id, String content, Integer degree, Integer quality) {
        // 添加一条评价
        Evaluation evaluation = new Evaluation()
                .setLesson_id(lesson_id)
                .setEvaluation_date(new Date())
                .setEvaluation_content(content)
                .setEvaluation_degree(degree)
                .setEvaluation_quality(quality);
        evaluationMapper.insert(evaluation);

        // 关联对应学生
        evaluationMapper.issue(student_id, evaluation.getEvaluation_id());
        return 0;
    }
}
