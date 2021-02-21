package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Period;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PeriodMapper extends BaseMapper<Period> {

}