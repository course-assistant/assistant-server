package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.PeriodTest;

import java.util.List;

public interface PeriodTestService {

    /**
     * 根据学时id查询测试
     *
     * @param period_id period_id
     * @return PeriodTest
     */
    List<PeriodTest> selectPeriodTestByPeriodId(Integer period_id);
}
