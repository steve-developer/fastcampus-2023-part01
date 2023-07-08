package org.example.ex09;

public class Exam09 {


    public Exam09(StoreUser storeUser){
        // service logic

        if(storeUser.getRole().equals("MASTER")){
            // master
        }
        else if(storeUser.getRole().equals("ADMIN")){
            // admin
        }
        else if(storeUser.getRole().equals("USER")){
            // user
        }
        else {
            // default
        }

        var role = "";
        switch (storeUser.getRole()){
            case "MASTER" :
            case "ADMIN" :
                role = "MASTER";
            break;
            case "USER" :

            break;
            default :
                // default ??
            break;
        }

        try{

        }catch (Exception e){
            var result = "";
            if(e instanceof NullPointerException){

            }
            else if(e instanceof NumberFormatException){

            }

        }
    }

    public static void main(String[] args){
        new Exam09(new StoreUser());
    }
}


class StoreUser{
    private String name;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}