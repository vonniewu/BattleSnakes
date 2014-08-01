package com.hakrx.battlesnakes.arenas;

import com.hakrx.battlesnakes.Point;
import com.hakrx.battlesnakes.controllers.Controller;
import com.hakrx.battlesnakes.controllers.ControllerButton;
import com.hakrx.battlesnakes.controllers.KeyBoardController;
import com.hakrx.battlesnakes.controllers.WasdController;
import com.hakrx.battlesnakes.snakes.AbstractSnake;

import java.util.LinkedList;

public class SnakeArena {

    private Controller player1Controller = new KeyBoardController();
    private Controller player2Controller = new WasdController();
    private AbstractSnake player1Snake;
    private AbstractSnake player2Snake;

    private int dimension;
    private LinkedList<Point<Integer>> borderPoints;
    private LinkedList<Point<Integer>> obstaclePoints;
    private LinkedList<Point<Integer>> foodPoints;

    public SnakeArena(int dimension, AbstractSnake player1, AbstractSnake player2) {
        this.dimension = dimension;
        this.borderPoints = new LinkedList<Point<Integer>>();
        this.obstaclePoints = new LinkedList<Point<Integer>>();
        this.foodPoints = new LinkedList<Point<Integer>>();

        this.player1Snake = player1;
        this.player2Snake = player2;

        for (int i = 0; i < dimension; i++) {
            borderPoints.add(new Point<Integer>(0, i));
            borderPoints.add(new Point<Integer>(i, 0));

            borderPoints.add(new Point<Integer>(dimension - 1, i));
            borderPoints.add(new Point<Integer>(i, dimension - 1));
        }
    }

    public void update() {
        // Update Controllers
        player1Controller.update();
        player2Controller.update();

        // Check Player 1 Movememnt
        if (player1Controller.isButtonPressed(ControllerButton.UP)) player1Snake.setDirection(AbstractSnake.Direction.UP);
        else if (player1Controller.isButtonPressed(ControllerButton.DOWN)) player1Snake.setDirection(AbstractSnake.Direction.DOWN);
        else if (player1Controller.isButtonPressed(ControllerButton.LEFT)) player1Snake.setDirection(AbstractSnake.Direction.LEFT);
        else if (player1Controller.isButtonPressed(ControllerButton.RIGHT)) player1Snake.setDirection(AbstractSnake.Direction.RIGHT);

        player1Snake.advanceSnake();


        // Check Player 1 Movememnt
        if (player2Controller.isButtonPressed(ControllerButton.UP)) player2Snake.setDirection(AbstractSnake.Direction.UP);
        else if (player2Controller.isButtonPressed(ControllerButton.DOWN)) player2Snake.setDirection(AbstractSnake.Direction.DOWN);
        else if (player2Controller.isButtonPressed(ControllerButton.LEFT)) player2Snake.setDirection(AbstractSnake.Direction.LEFT);
        else if (player2Controller.isButtonPressed(ControllerButton.RIGHT)) player2Snake.setDirection(AbstractSnake.Direction.RIGHT);

        player2Snake.advanceSnake();
    }

    public int getDimension() {
        return dimension;
    }

    public void setPlayer1Snake(AbstractSnake snake) {
        player1Snake = snake;
    }

    public AbstractSnake getPlayer1Snake() {
        return player1Snake;
    }

    public void setPlayer2Snake(AbstractSnake snake) {
        player2Snake = snake;
    }

    public AbstractSnake getPlayer2Snake() {
        return player2Snake;
    }

    public void setPlayer1Controller(Controller controller) {
        player1Controller = controller;
    }

    public void setPlayer2Controller(Controller controller) {
        player2Controller = controller;
    }

    public LinkedList<Point<Integer>> getBorderPoints() {
        return borderPoints;
    }

    public LinkedList<Point<Integer>> getObstaclePoints() {
        return obstaclePoints;
    }

    public LinkedList<Point<Integer>> getFoodPoints() {
        return foodPoints;
    }
}
