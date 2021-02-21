package cn.hncj.assistant.dto;

import cn.hncj.assistant.entity.Period;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeekPeriodDTO {
    Integer week_id;
    String week_name;
    List<Period> periods;
}
