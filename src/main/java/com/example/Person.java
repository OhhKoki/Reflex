package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("all")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    public String name;
    protected String age;
    String sex;
    private String adress;

    private Person(String  sex, String adress) {
        this.sex = sex;
        this.adress = adress;
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void eat(String food) {
        System.out.println(food);
    }

    private void sleep() {
        System.out.println("睡觉");
    }

}
