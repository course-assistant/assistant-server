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
public class Student implements Serializable {
    private String student_id;
    private String administrator_id;
    private String student_name;
    private String student_password;
    private Short student_sex;
    private String student_avatar;
    private String student_phone;
    private String student_email;
    private String student_wx;
    private Short student_status;
}
