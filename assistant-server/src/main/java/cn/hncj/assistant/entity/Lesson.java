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
public class Lesson {
    @TableId(type = IdType.AUTO)
    Integer lesson_id;
    Integer course_id;
    String lesson_name;
    Integer lesson_index = -1;
    Integer lesson_type = 1;
    Integer lesson_status;
    String lesson_content;
}
