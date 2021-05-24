package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.Question;
import cn.hncj.assistant.mapper.QuestionMapper;
import cn.hncj.assistant.service.QuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    /**
     * 获取所有题目
     *
     * @param id id
     * @return question
     */
    @Override
    public List<Question> all(Integer id) {


//        System.out.println("cid " + id);

        QueryWrapper<Question> queryWrapper = new QueryWrapper<Question>().eq("course_id", id);

//        System.out.println(questionList);

        return questionMapper.selectList(queryWrapper);
    }
}
