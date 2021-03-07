package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.PeriodTest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface PeriodTestMapper extends BaseMapper<PeriodTest> {

    /**
     * 发布
     *
     * @param period_test_id period_test_id
     * @return int
     */
    Integer issue(@Param("period_test_id") Integer period_test_id);

}