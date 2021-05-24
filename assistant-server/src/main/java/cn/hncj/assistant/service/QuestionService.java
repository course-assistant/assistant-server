package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.Question;

import java.util.List;

public interface QuestionService {


    /**
     * 获取所有题目
     *
     * @param id id
     * @return question
     */
    List<Question> all(Integer id);

}
