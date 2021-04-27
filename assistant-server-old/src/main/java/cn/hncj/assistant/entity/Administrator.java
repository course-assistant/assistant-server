package cn.hncj.assistant.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class Administrator implements Serializable {
    private String administrator_id;
    private String administrator_password;
    private Short administrator_permission;
}
