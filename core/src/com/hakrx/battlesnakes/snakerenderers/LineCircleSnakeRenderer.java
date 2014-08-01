package com.hakrx.battlesnakes.snakerenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;

import java.awt.*;

/**
 * Created by vonniewu on 7/31/14.
 */
public class LineCircleSnakeRenderer extends SnakeRenderer {
    @Override
    public ShapeRenderer.ShapeType getShapeType() {
        return ShapeRenderer.ShapeType.Line;
    }

    @Override
    public void renderAt(Point<Integer> pixelCoordinate, int tileDimension, ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(pixelCoordinate.getX(), pixelCoordinate.getY(), tileDimension/2);
    }
}
