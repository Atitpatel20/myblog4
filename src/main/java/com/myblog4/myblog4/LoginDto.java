package com.myblog4.myblog4;

public class LoginDto {
    private String userName;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

//    @Override
//    public String toString() {
//        return "LoginDto{" + "userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
