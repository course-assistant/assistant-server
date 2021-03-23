package cn.hncj.assistant.mapper;

import cn.hncj.assistant.dto.EvaluationDTO;
import cn.hncj.assistant.entity.PeriodEvaluate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PeriodEvaluateMapper extends BaseMapper<PeriodEvaluate> {

    /**
     * 查询学时评价
     *
     * @param period_id period_id
     * @return EvaluationDTO
     */
    List<EvaluationDTO> selectEvaluations(@Param("period_id") Integer period_id);


    /**
     * 查询平均分数 只给两个平均分赋值
     *
     * @param period_id period_id
     * @return PeriodEvaluationDTO 只给两个平均分赋值
     */
    Map<String, Float> selectAvg(@Param("period_id") Integer period_id);

}