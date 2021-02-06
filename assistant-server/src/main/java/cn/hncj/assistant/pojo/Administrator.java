package cn.hncj.assistant.pojo;

import java.io.Serializable;

public class Administrator implements Serializable {
    private String administrator_id;
    private String administrator_password;
    private Short administrator_permission;

    public Administrator() {
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administrator_id='" + administrator_id + '\'' +
                ", administrator_password='" + administrator_password + '\'' +
                ", administrator_permission=" + administrator_permission +
                '}';
    }

    public String getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(String administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getAdministrator_password() {
        return administrator_password;
    }

    public void setAdministrator_password(String administrator_password) {
        this.administrator_password = administrator_password;
    }

    public Short getAdministrator_permission() {
        return administrator_permission;
    }

    public void setAdministrator_permission(Short administrator_permission) {
        this.administrator_permission = administrator_permission;
    }
}
