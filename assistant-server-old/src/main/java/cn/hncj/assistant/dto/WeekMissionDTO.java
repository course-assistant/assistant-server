package cn.hncj.assistant.dto;

import cn.hncj.assistant.entity.WeekGoal;
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
public class WeekMissionDTO {
    Integer week_mission_id;
    Integer week_id;
    String week_name;
    String week_mission_name;
    Integer week_mission_type;
    Integer week_mission_status;
    String week_mission_content;
//    String teacher_name;
    Integer views;
    List<WeekGoal> week_goals;
}
