package com.hakrx.battlesnakes.snakerenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;

/**
 * Created by vonniewu on 7/31/14.
 */
public class CircleSnakeRenderer extends SnakeRenderer{

    @Override
    public ShapeRenderer.ShapeType getShapeType() {
        return ShapeRenderer.ShapeType.Filled;
    }

    @Override
    public void renderAt(Point<Integer> pixelCoordinate, int tileDimension, ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(pixelCoordinate.getX()-1, pixelCoordinate.getY()-1, tileDimension/2);

    }
}
