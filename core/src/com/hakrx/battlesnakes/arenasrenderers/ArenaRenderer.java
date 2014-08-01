package com.hakrx.battlesnakes.arenasrenderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.hakrx.battlesnakes.Point;
import com.hakrx.battlesnakes.ScreenProperties;
import com.hakrx.battlesnakes.arenas.SnakeArena;
import com.hakrx.battlesnakes.snakerenderers.SnakeRenderer;

public abstract class ArenaRenderer {

    protected ShapeRenderer shapeRenderer;
    protected SnakeRenderer player1Renderer;
    protected SnakeRenderer player2Renderer;
    protected SnakeArena snakeArena;

    protected int tileDimension;

    public ArenaRenderer(SnakeArena snakeArena, ShapeRenderer shapeRenderer, SnakeRenderer player1Renderer, SnakeRenderer player2Renderer) {
        this.shapeRenderer = shapeRenderer;
        this.snakeArena = snakeArena;
        this.player1Renderer = player1Renderer;
        this.player2Renderer = player2Renderer;

        tileDimension = Math.min(ScreenProperties.VIRTUAL_WIDTH, ScreenProperties.VIRTUAL_HEIGHT)/snakeArena.getDimension();
    }

    public void setSnakeArena(SnakeArena snakeArena) {
        this.snakeArena = snakeArena;
    }

    public void setPlayer1Renderer(SnakeRenderer player1Renderer) {
        this.player1Renderer = player1Renderer;
    }

    public void setPlayer2Renderer(SnakeRenderer player2Renderer) {
        this.player2Renderer = player2Renderer;
    }

    public void draw() {
        // Render Arena Boundries
        shapeRenderer.begin(getBorderShapeType());
        for (Point<Integer> borderPoint : snakeArena.getBorderPoints()) {
            drawBorderPoint(borderPoint);
        }
        shapeRenderer.end();

        // Render Arena Obstacles
        shapeRenderer.begin(getObstacleShapeType());
        for (Point<Integer> obstaclePoint : snakeArena.getObstaclePoints()) {
            drawObstaclePoint(obstaclePoint);
        }
        shapeRenderer.end();

        // Render Food
        shapeRenderer.begin(getFoodShapeType());
        for (Point<Integer> foodPoint : snakeArena.getFoodPoints()) {
           drawFoodPoint(foodPoint);
        }
        shapeRenderer.end();

        // Render Snakes
        player1Renderer.renderSnake(this, snakeArena.getPlayer1Snake());
        player2Renderer.renderSnake(this, snakeArena.getPlayer2Snake());
    }

    public Point<Integer> getPixelCoordinates(Point<Integer> boardCoordinate) {
        return new Point<Integer>(boardCoordinate.getX() * tileDimension, boardCoordinate.getY() * tileDimension);
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public int getTileDimension() {
        return tileDimension;
    }

    public abstract ShapeRenderer.ShapeType getBorderShapeType();
    public abstract ShapeRenderer.ShapeType getObstacleShapeType();
    public abstract ShapeRenderer.ShapeType getFoodShapeType();

    public abstract void drawBorderPoint(Point<Integer> borderPoint);
    public abstract void drawObstaclePoint(Point<Integer> obstaclePoint);
    public abstract void drawFoodPoint(Point<Integer> foodPoint);
}
