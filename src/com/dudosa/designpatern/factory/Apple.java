package com.dudosa.designpatern.factory;

public class Apple implements Fruit {
    @Override
    public void produceJuice() {
        System.out.println("Here there is an apple juice");
    }
}
