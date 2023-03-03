package com.dudosa.strings.numbers.designpatern.abs_factory;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        System.out.println("Pattern abstract Factory: Vehicle Factory 1...");
        AbstractFactory carFactory = FactoryProvider.getFactory("car");
        Vehicle slowCar = carFactory.createVehicle("slow");
        slowCar.move();
    }
}
