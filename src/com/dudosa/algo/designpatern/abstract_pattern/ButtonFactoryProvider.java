package com.dudosa.strings.numbers.designpatern.abstract_pattern;

public class ButtonFactoryProvider {

    public static ButtonFactory getButtonFactory(String osName){
        if (osName.equals("win")){
            return  new WinButtonFactory();
        } else if ( osName.equals("mac")) {
            return new MacButtonFactory();
        } else {
            throw new RuntimeException("Not implemented yet!");
        }
    }
}
