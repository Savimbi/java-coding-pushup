package com.dudosa.strings.numbers.designpatern.abs_factory;

final class FactoryProvider {

    private  FactoryProvider(){}
    static AbstractFactory getFactory(String type){
        return  switch (type){
            case "car" -> new CarFactory();
            case "truck" -> new TruckFactory();
            default -> throw  new IllegalArgumentException("""
                    This is %s
                    """.formatted(type));
        };
    }
}
