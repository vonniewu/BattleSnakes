package com.hakrx.battlesnakes.snakes;

import com.badlogic.gdx.graphics.Color;

public class SuperRainbowSnake extends RainbowSnake {

    private int rainbowCount = 0;

    public SuperRainbowSnake(int headX, int headY, int initialLength, Direction direction) {
        super(headX, headY, initialLength, direction);
    }

    @Override
    public void advanceSnake() {
        rainbowCount++;

        super.advanceSnake();
    }

    @Override
    public Color getSnakeBodyColor(int i) {
        return super.getSnakeBodyColor(i + rainbowCount);
    }
}
