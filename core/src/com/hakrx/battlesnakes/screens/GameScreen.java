package com.hakrx.battlesnakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hakrx.battlesnakes.BattleSnakesGame;
import com.hakrx.battlesnakes.GameState;
import com.hakrx.battlesnakes.ScreenProperties;
import com.hakrx.battlesnakes.arenas.SnakeArena;
import com.hakrx.battlesnakes.arenasrenderers.ArenaRenderer;
import com.hakrx.battlesnakes.arenasrenderers.BoxFrameArenaRenderer;
import com.hakrx.battlesnakes.controllers.Controller;
import com.hakrx.battlesnakes.controllers.ControllerButton;
import com.hakrx.battlesnakes.snakerenderers.SegmentedSnakeRenderer;
import com.hakrx.battlesnakes.snakerenderers.SolidSnakeRenderer;
import com.hakrx.battlesnakes.snakes.AbstractSnake;
import com.hakrx.battlesnakes.snakes.SuperRainbowSnake;

public class GameScreen implements Screen {
    ShapeRenderer shapeRenderer;

    OrthographicCamera camera;
    FitViewport viewport;
    SnakeArena arena;
    ArenaRenderer renderer;
    BattleSnakesGame game;
    long lastUpdateMillis;

    Controller player1Controller;
    Controller player2Controller;

    public GameScreen(BattleSnakesGame game) {
        this.game = game;
    }

    @Override
    public void show () {
        camera = new OrthographicCamera(ScreenProperties.VIRTUAL_WIDTH, ScreenProperties.VIRTUAL_HEIGHT);
        viewport = new FitViewport(ScreenProperties.VIRTUAL_WIDTH, ScreenProperties.VIRTUAL_HEIGHT, camera);

        camera.zoom += 0.05f;
        camera.update();

        shapeRenderer = new ShapeRenderer();
        arena = new SnakeArena(50, new SuperRainbowSnake(5, 5, 5, AbstractSnake.Direction.RIGHT), new SuperRainbowSnake(10, 10, 5, AbstractSnake.Direction.LEFT));
        renderer = new BoxFrameArenaRenderer(arena, shapeRenderer, new SegmentedSnakeRenderer(), new SolidSnakeRenderer());

        lastUpdateMillis = TimeUtils.millis();

        player1Controller = arena.getPlayer1Controller();
        player2Controller = arena.getPlayer2Controller();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void render (float delta) {
        // Updates
        if (game.getState() == GameState.RUNNING && (player1Controller.isButtonPressed(ControllerButton.START) || player2Controller.isButtonPressed(ControllerButton.START))) {
            game.pauseGame();
        }

        if (TimeUtils.millis() - lastUpdateMillis < 75) {
            return;
        }

        lastUpdateMillis = TimeUtils.millis();

        // Draw
        Gdx.gl.glClearColor(51/255f, 51/255f, 51/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(camera.projection);
        shapeRenderer.setTransformMatrix(camera.view);

        arena.update();
        renderer.draw();
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
