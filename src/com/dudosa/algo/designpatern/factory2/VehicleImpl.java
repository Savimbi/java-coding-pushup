package com.dudosa.strings.numbers.designpatern.factory2;

public class VehicleImpl {

    public static void main(String[] args) {
        System.out.println("Pattern Factory Mathod: Vehicle factory 2");
        var sportCar = VehicleFactory.produce("sport");
        System.out.println("Sport-car:"+ sportCar);
        sportCar.move();
    }
}
