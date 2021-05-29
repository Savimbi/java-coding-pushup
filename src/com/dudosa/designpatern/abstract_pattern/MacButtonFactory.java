package com.dudosa.designpatern.abstract_pattern;

public class MacButtonFactory extends ButtonFactory {
    @Override
    public MacButton createButton(boolean rounded) {
        if (rounded){
            return  new RoundedMacButton();
        } else {
            return  new MacButton();
        }
    }
}
