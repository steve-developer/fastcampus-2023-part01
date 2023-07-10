package org.example.ex03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam03 {

    public Exam03(){
        // 코드 작성
        var userList = new ArrayList<User>();
        userList.add(new User("1",10));
        userList.add(new User("2",10));
        userList.add(new User("3",10));

        var list = Arrays.asList(
            new User("4",20),
            new User("5",20),
            new User("6",20)
        );

        userList.forEach(System.out::println);

        for(int i =0; i < userList.size(); i++){
            var dto = userList.get(i);
            System.out.println("index : "+i + " user name : "+dto.getName());
        }

        for(User element: userList){
            System.out.println(element);
        }

        var immutable = Collections.unmodifiableCollection(userList);
        //immutable.add(new User("5",60));

        var imList = List.of("");
        imList.add("");
    }



    public static void main(String[] args){
        new Exam03();
    }
}


class User{
    private String name;
    private int age;

    public User(){

    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}