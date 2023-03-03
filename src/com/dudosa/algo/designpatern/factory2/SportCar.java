package com.dudosa.strings.numbers.designpatern.factory2;

public record SportCar(String type) implements Vehicle {
    @Override
    public  void move(){
        System.out.println("""
                sportCar, type:'%s', move
                """.formatted(type));
    }
}
