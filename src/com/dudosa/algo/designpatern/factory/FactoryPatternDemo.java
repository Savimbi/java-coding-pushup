package com.dudosa.strings.numbers.designpatern.factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        FruitFactory factory = new FruitFactory();

        //Create apple object using factory and call producejuice method
        Fruit fruit = factory.getFruit("apple");
        fruit.produceJuice();

        // create an orange
        fruit = factory.getFruit("orange");
        fruit.produceJuice();

        // Create banana
        fruit = factory.getFruit("banana");
        fruit.produceJuice();
    }
}
