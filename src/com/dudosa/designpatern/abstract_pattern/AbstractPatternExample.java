package com.dudosa.designpatern.abstract_pattern;

public class AbstractPatternExample {
    public static void main(String[] args) {
        ButtonFactory buttonFactory = ButtonFactoryProvider.getButtonFactory("win");
        Button button = buttonFactory.createButton(false);
        button.onClick();

        button = buttonFactory.createButton(true);
        button.onClick();

        buttonFactory = ButtonFactoryProvider.getButtonFactory("mac");

        button = buttonFactory.createButton(false);
        button.onClick();

        button = buttonFactory.createButton(true);
        button.onClick();
    }
}
