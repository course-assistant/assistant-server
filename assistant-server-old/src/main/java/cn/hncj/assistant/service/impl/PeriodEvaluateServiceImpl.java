package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.dto.EvaluationDTO;
import cn.hncj.assistant.dto.PeriodEvaluationDTO;
import cn.hncj.assistant.entity.PeriodEvaluate;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.mapper.PeriodEvaluateMapper;
import cn.hncj.assistant.service.PeriodEvaluateService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PeriodEvaluateServiceImpl implements PeriodEvaluateService {

    @Autowired
    PeriodEvaluateMapper periodEvaluateMapper;

    /**
     * 查询学时的评价
     *
     * @param period_id period_id
     * @return PeriodEvaluationDTO
     */
    @Override
    public PeriodEvaluationDTO select(Integer period_id) {
        PeriodEvaluationDTO periodEvaluationDTO = new PeriodEvaluationDTO();

        // 查询平均分数
        Map<String, Float> map = periodEvaluateMapper.selectAvg(period_id);

        // 查询结果为空时
        if (map == null) {
            periodEvaluationDTO = new PeriodEvaluationDTO()
                    .setAvg_quality("0.0").setAvg_degree("0.0").setEvaluation_count(0).setEvaluations(new ArrayList<>());
            return periodEvaluationDTO;
        }
        // 保留一位小数
        String avg_degree = String.format("%.1f", map.get("avg_degree"));
        String avg_quality = String.format("%.1f", map.get("avg_quality"));

        // 查询所有评价
        List<EvaluationDTO> evaluations = periodEvaluateMapper.selectEvaluations(period_id);

        periodEvaluationDTO
                .setAvg_degree(avg_degree)
                .setAvg_quality(avg_quality)
                .setEvaluation_count(evaluations.size());

        // 将空白的评论从list里面删除
        /*
        while (iterator.hasNext()) {
            EvaluationDTO evaluationDTO = iterator.next();
            if (evaluationDTO.getPeriod_evaluate_content() == null || "".equals(evaluationDTO.getPeriod_evaluate_content().trim())) {
                iterator.remove();
            }
        }
*/
        evaluations.removeIf(
                evaluationDTO ->
                        evaluationDTO.getPeriod_evaluate_content() == null || "".equals(evaluationDTO.getPeriod_evaluate_content().trim())
        );

        periodEvaluationDTO.setEvaluations(evaluations);
        return periodEvaluationDTO;
    }

    /**
     * 发布评价
     *
     * @param period_id  学时id
     * @param student_id 学生id
     * @param content    内容
     * @param degree     掌握度
     * @param quality    教学质量
     * @return int
     */
    @Override
    public Integer issue(Integer period_id, String student_id, String content, Integer degree, Integer quality) {
        // 判断该学生是否已经进行评价
        QueryWrapper<PeriodEvaluate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("period_id", period_id);
        queryWrapper.eq("student_id", student_id);
        Integer count = periodEvaluateMapper.selectCount(queryWrapper);
        if (count >= 1) {
            throw new ServerException("不能重复评价");
        }
        // 发布
        PeriodEvaluate periodEvaluate = new PeriodEvaluate()
                .setPeriod_id(period_id)
                .setStudent_id(student_id)
                .setPeriod_evaluate_content(content)
                .setPeriod_evaluate_degree(degree)
                .setPeriod_evaluate_quality(quality)
                .setPeriod_evaluate_date(new Date());
        return periodEvaluateMapper.insert(periodEvaluate);
    }
}
