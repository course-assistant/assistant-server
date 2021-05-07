package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.Evaluation;

import java.util.List;

public interface EvaluationService {


    List<Evaluation> selectById(Integer id);


    Integer issue(Integer lesson_id, String student_id, String content, Integer degree, Integer quality);

}
