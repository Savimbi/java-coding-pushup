package com.dudosa.strings.numbers.designpatern.abs_factory;


public class TruckFactory extends  AbstractFactory{
    @Override
    Vehicle createVehicle(String type) {
        return  switch (type){
            case "heavy" -> new HeavyTruck();
            case "light" -> new LightTruck();
            default -> throw new IllegalArgumentException("not implemented");
        };
    }
}
