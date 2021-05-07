package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.Evaluation;

import java.util.List;

public interface EvaluationService {


    List<Evaluation> selectById(Integer id);

}
