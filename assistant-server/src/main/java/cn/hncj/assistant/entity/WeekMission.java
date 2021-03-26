package cn.hncj.assistant.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class WeekMission {
    @TableId(type = IdType.AUTO)
    Integer week_mission_id;
    Integer week_id;
    String week_mission_name;
    String week_mission_content;
    Integer week_mission_status;
    Integer week_mission_type;
}
