package com.codfish.springbootquickstart.response.user;

import java.io.Serializable;

public class LoginResp implements Serializable {
    private static final long serialVersionUID = 6985103412744013659L;

    private Long id;

    private String username;

    private String fullname;

    private Long sysDepartmentId;

    private Boolean isLocked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getSysDepartmentId() {
        return sysDepartmentId;
    }

    public void setSysDepartmentId(Long sysDepartmentId) {
        this.sysDepartmentId = sysDepartmentId;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }
}
