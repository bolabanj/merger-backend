package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class Details {
    String name;
    String email;
    String password;
    public Details(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Details() {

    }

    public String name(){
        return name;
    }
    public String email(){
        return email;
    }
    public String password(){
        return password;
    }
    public void setName(String newName){
        this.name = newName;

    }
    public void setEmail(String newEmail){
        this.email = newEmail;

    }
    public void setPassword(String newPassword){
        this.password = newPassword;

    }
}
