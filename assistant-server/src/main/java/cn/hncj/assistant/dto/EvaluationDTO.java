package cn.hncj.assistant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvaluationDTO {
    String student_id;
    String student_name;
    String student_avatar;
    Integer period_evaluate_id;
    Integer period_id;
    String period_evaluate_content;
    Date period_evaluate_date;
    Integer period_evaluate_quality;
    Integer period_evaluate_degree;
}
