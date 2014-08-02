package com.hakrx.battlesnakes.snakerenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;

/**
 * Created by vonniewu on 7/31/14.
 */
public class LineSnakeRenderer extends SnakeRenderer{
    @Override
    public ShapeRenderer.ShapeType getShapeType() {
        return ShapeRenderer.ShapeType.Line;
    }

    @Override
    public void renderAt(Point<Integer> pixelCoordinate, int tileDimension, ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(pixelCoordinate.getX(), pixelCoordinate.getY(), tileDimension, tileDimension);
    }
}
