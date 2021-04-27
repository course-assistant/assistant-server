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
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
@ToString
public class Student implements Serializable {
    @TableId
    private String student_id;
    private String administrator_id;
    private String student_name;
    private String student_password = "670B14728AD9902AECBA32E22FA4F6BD";
    private Integer student_sex = 0;
    private String student_avatar = "avatar";
    private String student_phone = "";
    private String student_email = "";
    private String student_wx = "";
    private Short student_status = 1;
}
