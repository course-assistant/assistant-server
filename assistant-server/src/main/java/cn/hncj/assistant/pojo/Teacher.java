package cn.hncj.assistant.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

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

    public Teacher() {
    }

    public Teacher(Integer teacher_id, String administrator_id, String teacher_name, String teacher_password, Short teacher_sex, String teacher_avatar, String teacher_phone, String teacher_email, String teacher_wx, Short teacher_status) {
        this.teacher_id = teacher_id;
        this.administrator_id = administrator_id;
        this.teacher_name = teacher_name;
        this.teacher_password = teacher_password;
        this.teacher_sex = teacher_sex;
        this.teacher_avatar = teacher_avatar;
        this.teacher_phone = teacher_phone;
        this.teacher_email = teacher_email;
        this.teacher_wx = teacher_wx;
        this.teacher_status = teacher_status;
    }

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

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(String administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public Short getTeacher_sex() {
        return teacher_sex;
    }

    public void setTeacher_sex(Short teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public String getTeacher_avatar() {
        return teacher_avatar;
    }

    public void setTeacher_avatar(String teacher_avatar) {
        this.teacher_avatar = teacher_avatar;
    }

    public String getTeacher_phone() {
        return teacher_phone;
    }

    public void setTeacher_phone(String teacher_phone) {
        this.teacher_phone = teacher_phone;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getTeacher_wx() {
        return teacher_wx;
    }

    public void setTeacher_wx(String teacher_wx) {
        this.teacher_wx = teacher_wx;
    }

    public Short getTeacher_status() {
        return teacher_status;
    }

    public void setTeacher_Status(Short teacher_status) {
        this.teacher_status = teacher_status;
    }
}
