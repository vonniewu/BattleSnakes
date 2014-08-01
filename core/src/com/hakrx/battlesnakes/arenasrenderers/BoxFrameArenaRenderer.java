package com.hakrx.battlesnakes.arenasrenderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;
import com.hakrx.battlesnakes.arenas.SnakeArena;
import com.hakrx.battlesnakes.snakerenderers.SnakeRenderer;

public class BoxFrameArenaRenderer extends ArenaRenderer {

    public BoxFrameArenaRenderer(SnakeArena snakeArena, ShapeRenderer shapeRenderer, SnakeRenderer player1Renderer, SnakeRenderer player2Renderer) {
        super(snakeArena, shapeRenderer, player1Renderer, player2Renderer);
    }

    @Override
    public ShapeRenderer.ShapeType getBorderShapeType() {
        return ShapeRenderer.ShapeType.Line;
    }

    @Override
    public ShapeRenderer.ShapeType getObstacleShapeType() {
        return ShapeRenderer.ShapeType.Line;
    }

    @Override
    public ShapeRenderer.ShapeType getFoodShapeType() {
        return ShapeRenderer.ShapeType.Line;
    }

    @Override
    public void drawBorderPoint(Point<Integer> borderPoint) {
        shapeRenderer.setColor(Color.GRAY);
        Point<Integer> piecePixelPoint = getPixelCoordinates(borderPoint);
        shapeRenderer.rect(piecePixelPoint.getX(), piecePixelPoint.getY(), tileDimension, tileDimension);
    }

    @Override
    public void drawObstaclePoint(Point<Integer> obstaclePoint) {
        shapeRenderer.setColor(Color.GRAY);
        Point<Integer> piecePixelPoint = getPixelCoordinates(obstaclePoint);
        shapeRenderer.rect(piecePixelPoint.getX(), piecePixelPoint.getY(), tileDimension, tileDimension);
    }

    @Override
    public void drawFoodPoint(Point<Integer> foodPoint) {
        shapeRenderer.setColor(Color.GRAY);
        Point<Integer> piecePixelPoint = getPixelCoordinates(foodPoint);
        shapeRenderer.rect(piecePixelPoint.getX(), piecePixelPoint.getY(), tileDimension, tileDimension);
    }
}
