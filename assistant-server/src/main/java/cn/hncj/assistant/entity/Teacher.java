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
    private Integer teacher_id;
    private String administrator_id;
    private String teacher_name;
    private String teacher_password;
    private Short teacher_sex;
    private String teacher_avatar;
    private String teacher_phone;
    private String teacher_email;
    private String teacher_wx;
    private Short teacher_status;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", administrator_id=" + administrator_id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                ", teacher_sex=" + teacher_sex +
                ", teacher_avatar='" + teacher_avatar + '\'' +
                ", teacher_phone='" + teacher_phone + '\'' +
                ", teacher_email='" + teacher_email + '\'' +
                ", teacher_wx='" + teacher_wx + '\'' +
                ", teacher_Status=" + teacher_status +
                '}';
    }
}
