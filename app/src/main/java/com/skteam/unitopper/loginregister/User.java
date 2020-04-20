package com.skteam.unitopper.loginregister;

public class User {
private String fullname, email, mobile_number, userpassword
        ,college_name,university, device_id, reg_date;
private boolean error;
private String error_msg;


    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getCollege_name() {
        return college_name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDevice_id() {
        return device_id;
    }

    public String getReg_date() {
        return reg_date;
    }

    public boolean isError() {
        return error;
    }

    public String getError_msg() {
        return error_msg;
    }
}
