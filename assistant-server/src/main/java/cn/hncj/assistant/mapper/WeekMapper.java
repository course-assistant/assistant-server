package cn.hncj.assistant.mapper;

import cn.hncj.assistant.entity.Week;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
@Repository
public interface WeekMapper extends BaseMapper<Week> {

    /**
     * 修改周
     *
     * @param week_id   week_id
     * @param week_name week_name
     * @return int
     */
    Integer updateWeek(
            @RequestParam("week_id") Integer week_id,
            @RequestParam("week_name") String week_name);

}