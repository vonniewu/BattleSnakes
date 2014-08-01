package com.hakrx.battlesnakes.snakerenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;

public class SolidSnakeRenderer extends SnakeRenderer {
    @Override
    public ShapeRenderer.ShapeType getShapeType() {
        return ShapeRenderer.ShapeType.Filled;
    }

    @Override
    public void renderAt(Point<Integer> pixelCoordinate, int tileDimension, ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(pixelCoordinate.getX(), pixelCoordinate.getY(), tileDimension, tileDimension);
    }
}
