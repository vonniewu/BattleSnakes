package com.hakrx.battlesnakes.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class WasdController implements Controller {

    private ControllerState previousState;
    private ControllerState currentState;

    public WasdController() {
        previousState = new ControllerState();
        currentState = new ControllerState();
    }

    public void update() {
        previousState = currentState;

        currentState = new ControllerState();

        // Set the state.

        // Up Button
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            currentState.setButtonState(ControllerButton.UP, ControllerButtonState.DOWN);
        }

        // Down Button
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            currentState.setButtonState(ControllerButton.DOWN, ControllerButtonState.DOWN);
        }

        // Left Button
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            currentState.setButtonState(ControllerButton.LEFT, ControllerButtonState.DOWN);
        }

        // Right Button
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            currentState.setButtonState(ControllerButton.RIGHT, ControllerButtonState.DOWN);
        }

        // Start Button
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            currentState.setButtonState(ControllerButton.START, ControllerButtonState.DOWN);
        }
    }

    public boolean isButtonPressed(ControllerButton button) {
        return previousState.getButtonState(button) == ControllerButtonState.UP && currentState.getButtonState(button) == ControllerButtonState.DOWN;
    }

    public boolean isButtonHeld(ControllerButton button) {
        return previousState.getButtonState(button) == ControllerButtonState.DOWN && currentState.getButtonState(button) == ControllerButtonState.DOWN;
    }

    public boolean isButtonReleased(ControllerButton button) {
        return previousState.getButtonState(button) == ControllerButtonState.DOWN && currentState.getButtonState(button) == ControllerButtonState.UP;
    }
}
