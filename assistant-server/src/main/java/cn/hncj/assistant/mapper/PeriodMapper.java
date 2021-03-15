package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Period;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PeriodMapper extends BaseMapper<Period> {


    /**
     * 修改period
     *
     * @param period_id     period_id
     * @param period_name   period_name
     * @param period_type   period_type
     * @param period_status period_status
     * @return int
     */
    Integer updatePeriod(
            @Param("period_id") Integer period_id,
            @Param("period_name") String period_name,
            @Param("period_content") String period_content,
            @Param("period_type") Integer period_type,
            @Param("period_status") Integer period_status
    );
}