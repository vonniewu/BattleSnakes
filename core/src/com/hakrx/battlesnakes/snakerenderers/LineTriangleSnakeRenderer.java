package com.hakrx.battlesnakes.snakerenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;

/**
 * Created by vonniewu on 7/31/14.
 */
public class LineTriangleSnakeRenderer extends SnakeRenderer{
    @Override
    public ShapeRenderer.ShapeType getShapeType() {
        return ShapeRenderer.ShapeType.Line;
    }

    @Override
    public void renderAt(Point<Integer> pixelCoordinate, int tileDimension, ShapeRenderer shapeRenderer) {
        shapeRenderer.triangle(pixelCoordinate.getX(), pixelCoordinate.getY(),
                pixelCoordinate.getX() + tileDimension, pixelCoordinate.getY(),
                pixelCoordinate.getX() + tileDimension/2, pixelCoordinate.getY() + tileDimension);
    }
}
