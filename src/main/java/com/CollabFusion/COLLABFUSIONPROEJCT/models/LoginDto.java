package com.CollabFusion.COLLABFUSIONPROEJCT.models;

import jakarta.validation.constraints.NotEmpty;

public class LoginDto {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password; 

    public String getUsername() { 
        return username; 
    }  

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { 
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
