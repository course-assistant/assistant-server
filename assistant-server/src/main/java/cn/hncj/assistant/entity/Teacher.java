package cn.hncj.assistant.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher implements Serializable {
    private String teacher_id;
    private String administrator_id;
    private String teacher_name;
    private String teacher_password;
    private Short teacher_sex;
    private String teacher_avatar;
    private String teacher_phone;
    private String teacher_email;
    private String teacher_wx;
    private Short teacher_status;

}
