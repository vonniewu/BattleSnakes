package com.hakrx.battlesnakes.snakes;

import com.badlogic.gdx.graphics.Color;
import com.hakrx.battlesnakes.Point;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractSnake {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private LinkedList<Point<Integer>> snakeBits;
    private Direction direction;
    private int initialLength;

    public AbstractSnake(int headX, int headY, int initialLength, Direction direction) {
        this.direction = direction;
        this.initialLength = initialLength;
        this.snakeBits = new LinkedList<Point<Integer>>();

        int dy = direction == Direction.UP ? 1 : direction == Direction.DOWN ? -1 : 0;
        int dx = direction == Direction.RIGHT ? 1 : direction == Direction.LEFT ? -1 : 0;

        for (int i = 0; i < initialLength + 1; i++) {
            snakeBits.add(new Point<Integer>(headX + (dx * i), headY + (dy * i)));
        }
    }

    public void grow() {
        snakeBits.add(snakeBits.getLast());
    }

    public void shrink() {
        snakeBits.removeLast();
    }

    public int size() {
        return snakeBits.size();
    }

    public Point<Integer> head() {
        return snakeBits.get(0);
    }

    public Point<Integer> bodyPieceAt(int i) {
        return snakeBits.get(i);
    }

    public void advanceSnake() {
        snakeBits.removeLast();

        Point<Integer> head = head().clone();

        switch (direction) {
            case UP:
                head.setY(head.getY() + 1);
                break;

            case DOWN:
                head.setY(head.getY() - 1);
                break;

            case LEFT:
                head.setX(head.getX() - 1);
                break;

            case RIGHT:
                head.setX(head.getX() + 1);
                break;
        }

        snakeBits.addFirst(head);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Iterator<Point<Integer>> snakeBodyIterator() {
        return snakeBits.listIterator(1);
    }

    public abstract Color getSnakeBodyColor(int i);
    public abstract Color getSnakeHeadColor();
}
