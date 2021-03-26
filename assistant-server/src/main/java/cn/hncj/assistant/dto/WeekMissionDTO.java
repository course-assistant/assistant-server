package cn.hncj.assistant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeekMissionDTO {
    Integer week_mission_id;
    String week_mission_name;
    Integer week_mission_type;
    Integer week_mission_status;
    String teacher_name;
    Integer views;
}
