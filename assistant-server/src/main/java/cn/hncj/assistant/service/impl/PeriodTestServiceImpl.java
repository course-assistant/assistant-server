package cn.hncj.assistant.service.impl;

import cn.hncj.assistant.entity.PeriodTest;
import cn.hncj.assistant.mapper.PeriodTestMapper;
import cn.hncj.assistant.service.PeriodTestService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class PeriodTestServiceImpl implements PeriodTestService {

    @Autowired
    PeriodTestMapper periodTestMapper;

    /**
     * 根据学时id查询测试
     *
     * @param period_id period_id
     * @return PeriodTest
     */
    @Override
    public List<PeriodTest> selectPeriodTestByPeriodId(Integer period_id) {
        QueryWrapper<PeriodTest> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("period_id", period_id);
        return periodTestMapper.selectList(queryWrapper);
    }
}
