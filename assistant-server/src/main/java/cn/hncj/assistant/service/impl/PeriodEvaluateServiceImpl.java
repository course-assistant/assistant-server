package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.PeriodEvaluate;
import cn.hncj.assistant.mapper.PeriodEvaluateMapper;
import cn.hncj.assistant.service.PeriodEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PeriodEvaluateServiceImpl implements PeriodEvaluateService {

    @Autowired
    PeriodEvaluateMapper periodEvaluateMapper;

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
