package cn.hncj.assistant.dto;

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
public class WeekInfoDTO {
    // 完成所有已发布的周任务的学生人数
    Integer student_ok_num;
    // 学生总人数
    Integer student_total_num;
    // 已发布的周数
    Integer week_published_num;
    // 所有周数
    Integer week_total_num;

    List<WeekDTO> weeks;
}
