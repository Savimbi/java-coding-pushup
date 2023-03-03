package com.dudosa.strings.numbers.designpatern.factory2;

public class SuvCar implements Vehicle{
    private final String type;
    public  SuvCar(String t){
        this.type = t;
    }

    @Override
    public  void  move(){
        System.out.println("""
                SuvCar, type:'%s', move
                """.formatted(type));
    }
}
