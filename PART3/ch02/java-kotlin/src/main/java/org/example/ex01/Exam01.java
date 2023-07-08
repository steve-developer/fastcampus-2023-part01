package org.example.ex01;

public class Exam01 {

    public Exam01(){
        // 코드 작성
        String name = "홍길동";
        String format = "사용자의 이름은 : %s";
        String result = String.format(format, name);
        System.out.println(result);

        int age = 10;       // 0
        Integer _age = 20;  // null

        double d = 10d;
        Double _d = 20.0;

        float f = 20f;
        Float _f = 20f;

        long l = 10L;
        Long _l = 10L;

        boolean bool = true;    // false
        Boolean _bool = true;
    }




    public static void main(String[] args){
        new Exam01();
    }
}
