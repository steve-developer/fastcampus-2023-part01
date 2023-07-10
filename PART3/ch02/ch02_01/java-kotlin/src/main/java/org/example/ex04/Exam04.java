package org.example.ex04;


import java.util.*;

public class Exam04 {

    public Exam04(){
        // 코드 작성
        var hashMap = new HashMap<String, Object>();
        hashMap.put("key","value");
        hashMap.put("key2", 10);

        var map = Map.of(
            "key1","" ,
            "key2", "",
            "key3",""
        );

        hashMap.get("key");

    }



    public static void main(String[] args){
        new Exam04();
    }
}
