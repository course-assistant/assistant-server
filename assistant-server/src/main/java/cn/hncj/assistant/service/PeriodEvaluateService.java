package cn.hncj.assistant.service;

import cn.hncj.assistant.dto.PeriodEvaluationDTO;

@SuppressWarnings("UnusedReturnValue")
public interface PeriodEvaluateService {


    /**
     * 查询学时的评价
     *
     * @param lesson_id lesson_id
     * @return PeriodEvaluationDTO
     */
    PeriodEvaluationDTO select(Integer lesson_id);


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
    Integer issue(Integer period_id, String student_id, String content, Integer degree, Integer quality);

}
