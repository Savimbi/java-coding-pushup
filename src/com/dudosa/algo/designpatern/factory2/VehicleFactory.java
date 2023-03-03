package com.dudosa.strings.numbers.designpatern.factory2;

final class VehicleFactory {
    private VehicleFactory(){}

    static Vehicle produce(String type){
        return  switch (type){
            case "sport" -> new SportCar("Porsche 911");
            case "suv" -> new SuvCar("Skoda");
            default ->  throw  new IllegalArgumentException("""
                    not implemented type: '%s'
                    """.formatted(type));
        };
    }
}
