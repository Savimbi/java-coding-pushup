package com.dudosa.designpatern.factory;

public class FruitFactory {
    Fruit getFruit(String name){
        switch (name){
            case "orange":
                return  new Orange();
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            default:
                throw new RuntimeException("No matching object could be created");

        }
    }
}
