package com.dudosa.designpatern.abstract_pattern;

public class WinButton implements Button{
    @Override
    public void onClick() {
        System.out.println("You clicked on Windows button");
    }
}
