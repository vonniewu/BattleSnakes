package com.hakrx.battlesnakes.snakerenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;
import com.hakrx.battlesnakes.arenasrenderers.ArenaRenderer;
import com.hakrx.battlesnakes.snakes.AbstractSnake;

import java.util.Iterator;

public abstract class SnakeRenderer {
    public void renderSnake(ArenaRenderer arenaRenderer, AbstractSnake snake) {
        ShapeRenderer shapeRenderer = arenaRenderer.getShapeRenderer();
        int tileDimension = arenaRenderer.getTileDimension();

        shapeRenderer.begin(getShapeType());

        // Render head
        shapeRenderer.setColor(snake.getSnakeHeadColor());
        renderAt(arenaRenderer.getPixelCoordinates(snake.head()), tileDimension, shapeRenderer);

        // Render body
        int currentColor = 1;
        for (Iterator<Point<Integer>> i = snake.snakeBodyIterator(); i.hasNext();) {
            shapeRenderer.setColor(snake.getSnakeBodyColor(currentColor));
            renderAt(arenaRenderer.getPixelCoordinates(i.next()), tileDimension, shapeRenderer);
            currentColor++;
        }

        shapeRenderer.end();
    }

    public abstract ShapeRenderer.ShapeType getShapeType();
    public abstract void renderAt(Point<Integer> pixelCoordinate, int tileDimension, ShapeRenderer shapeRenderer);
}
