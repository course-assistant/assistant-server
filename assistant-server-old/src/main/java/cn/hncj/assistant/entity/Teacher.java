package cn.hncj.assistant.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher implements Serializable {
    @TableId
    private String teacher_id;
    private String administrator_id;
    private String teacher_name;
    private String teacher_password = "670B14728AD9902AECBA32E22FA4F6BD";
    private Integer teacher_sex = 0;
    private String teacher_avatar = "avatar";
    private String teacher_phone = "";
    private String teacher_email = "";
    private String teacher_wx = "";
    private Integer teacher_status = 1;

}
