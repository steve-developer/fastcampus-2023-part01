package org.example.ex10;

import java.util.Optional;

public class Exam10 {

    public Exam10(ExamUser examUser){

        var optionalUser = Optional.ofNullable(examUser);
        optionalUser.ifPresent(it -> {
            Optional.ofNullable(examUser.getName()).ifPresent(name -> {

                if(!name.isBlank()){
                    System.out.println(name);
                }
            });

        });

        if(ObjectUtils.isNotNull(examUser) && ObjectUtils.isNotNull(examUser.getName())){

            if(StringUtils.notBlank(examUser.getName())){
                System.out.println(examUser.getName());
            }
        }
    }

    public static void main(String[] args){
        var user = new ExamUser();
        user.setName("abcd");

        new Exam10(user);
    }
}

class ObjectUtils {
    public static boolean isNotNull(Object obj){
        return obj != null;
    }
}

class StringUtils {

    public static boolean notBlank(String value){
        return !value.isBlank();
    }
}


class ExamUser{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
