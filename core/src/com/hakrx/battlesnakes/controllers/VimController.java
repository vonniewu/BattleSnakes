package com.hakrx.battlesnakes.controllers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class VimController implements Controller {

    private ControllerState previousState;
    private ControllerState currentState;

    public VimController() {
        previousState = new ControllerState();
        currentState = new ControllerState();
    }

    public void update() {
        previousState = currentState;

        currentState = new ControllerState();

        // Set the state.

        // Up Button
        if (Gdx.input.isKeyPressed(Input.Keys.K)) {
            currentState.setButtonState(ControllerButton.UP, ControllerButtonState.DOWN);
        }

        // Down Button
        if (Gdx.input.isKeyPressed(Input.Keys.J)) {
            currentState.setButtonState(ControllerButton.DOWN, ControllerButtonState.DOWN);
        }

        // Left Button
        if (Gdx.input.isKeyPressed(Input.Keys.H)) {
            currentState.setButtonState(ControllerButton.LEFT, ControllerButtonState.DOWN);
        }

        // Right Button
        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            currentState.setButtonState(ControllerButton.RIGHT, ControllerButtonState.DOWN);
        }

        // Start Button
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
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
