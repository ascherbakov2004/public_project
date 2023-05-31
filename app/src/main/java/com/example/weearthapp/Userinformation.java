package com.example.weearthapp;

public class Userinformation {

    public String name;
    public String nickname;
    public String phoneno;

    public Userinformation(){
    }

    public Userinformation(String name,String nickname, String phoneno){
        this.name = name;
        this.nickname = nickname;
        this.phoneno = phoneno;
    }
    public String getUserName() {
        return name;
    }
    public String getUserNickName() {
        return nickname;
    }
    public String getUserPhoneno() {
        return phoneno;
    }
}

