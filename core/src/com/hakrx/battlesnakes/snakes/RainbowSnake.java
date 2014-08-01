package com.hakrx.battlesnakes.snakes;

import com.badlogic.gdx.graphics.Color;

public class RainbowSnake extends AbstractSnake {

    public RainbowSnake(int headX, int headY, int initialLength, Direction direction) {
        super(headX, headY, initialLength, direction);
    }

    @Override
    public Color getSnakeBodyColor(int i) {
        float frequency = .1f;
        return new Color((float)Math.sin(frequency*i), (float)Math.sin(frequency*i + 2), (float)Math.sin(frequency*i + 4), 1f);
    }

    @Override
    public Color getSnakeHeadColor() {
        return getSnakeBodyColor(0);
    }
}
