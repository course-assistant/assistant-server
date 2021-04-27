package cn.hncj.assistant.service;

import cn.hncj.assistant.entity.PeriodTest;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface PeriodTestService {

    /**
     * 根据学时id查询测试
     *
     * @param period_id period_id
     * @return PeriodTest
     */
    List<PeriodTest> selectPeriodTestByPeriodId(Integer period_id);


    /**
     * 给学时添加测试
     *
     * @param period_id period_id
     * @param name      测试名字
     * @return int
     */
    Integer insertPeriodTest(Integer period_id, String name);


    /**
     * 发布测试
     *
     * @param id id
     * @return int
     */
    Integer issuePeriodTest(Integer id);


    /**
     * 删除测试
     *
     * @param id id
     * @return int
     */
    Integer deletePeriodTest(Integer id);
}
