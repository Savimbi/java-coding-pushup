package com.dudosa.designpatern.abstract_pattern;

public class WinButtonFactory extends ButtonFactory {
    @Override
    public WinButton createButton(boolean rounded) {
        if (rounded){
            return new RoundedWinButton();
        }
        else {
            return new WinButton();
        }
    }
}
