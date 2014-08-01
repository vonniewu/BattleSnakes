package com.hakrx.battlesnakes.controllers;

public interface Controller {
    boolean isButtonPressed(ControllerButton controllerButton);
    boolean isButtonHeld(ControllerButton controllerButton);
    boolean isButtonReleased(ControllerButton controllerButton);
    void update();

}
