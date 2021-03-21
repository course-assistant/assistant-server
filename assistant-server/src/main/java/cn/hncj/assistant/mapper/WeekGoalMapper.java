package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.WeekGoal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WeekGoalMapper extends BaseMapper<WeekGoal> {

}