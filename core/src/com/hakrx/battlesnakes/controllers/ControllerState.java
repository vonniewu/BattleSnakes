package com.hakrx.battlesnakes.controllers;

import java.util.HashMap;

public class ControllerState {
    private HashMap<ControllerButton, ControllerButtonState> buttonStates;

    public ControllerState() {
        buttonStates  = new HashMap<ControllerButton, ControllerButtonState>();

        // Add the initial button states.
        for (ControllerButton button : ControllerButton.values()) {
            buttonStates.put(button, ControllerButtonState.UP);
        }
    }

    public ControllerButtonState getButtonState(ControllerButton button) {
        return buttonStates.get(button);
    }

    public void setButtonState(ControllerButton button, ControllerButtonState buttonState) {
       buttonStates.put(button, buttonState);
    }
}
