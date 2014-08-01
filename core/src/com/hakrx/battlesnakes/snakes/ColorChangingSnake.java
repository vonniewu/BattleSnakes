package com.hakrx.battlesnakes.snakes;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by vonniewu on 8/1/14.
 */
public class ColorChangingSnake extends AbstractSnake {

    public ColorChangingSnake(int headX, int headY, int initialLength, Direction direction) {
        super(headX, headY, initialLength, direction);
    }

    @Override
    public Color getSnakeBodyColor(int i) {

        switch (direction) {
            case UP:
                return Color.CYAN;

            case DOWN:
                return Color.GREEN;

            case RIGHT:
                return Color.RED;

            case  LEFT:
                return Color.PINK;

            default:
                return Color.WHITE;
        }
    }

    @Override
    public Color getSnakeHeadColor() {
        return getSnakeBodyColor(0);
    }
}
