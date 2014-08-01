package com.hakrx.battlesnakes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.hakrx.battlesnakes.arenas.SnakeArena;
import com.hakrx.battlesnakes.arenasrenderers.ArenaRenderer;
import com.hakrx.battlesnakes.arenasrenderers.BoxFrameArenaRenderer;
import com.hakrx.battlesnakes.snakerenderers.SegmentedSnakeRenderer;
import com.hakrx.battlesnakes.snakerenderers.SolidSnakeRenderer;
import com.hakrx.battlesnakes.snakes.AbstractSnake;
import com.hakrx.battlesnakes.snakes.SuperRainbowSnake;

public class BattleSnakesGame extends ApplicationAdapter {
    ShapeRenderer shapeRenderer;

    SnakeArena arena;
    ArenaRenderer renderer;

    long lastUpdateMillis;

    @Override
    public void create () {
        shapeRenderer = new ShapeRenderer();
        arena = new SnakeArena(50, new SuperRainbowSnake(5, 5, 5, AbstractSnake.Direction.RIGHT), new SuperRainbowSnake(10, 10, 5, AbstractSnake.Direction.LEFT));
        renderer = new BoxFrameArenaRenderer(arena, shapeRenderer, new SegmentedSnakeRenderer(), new SolidSnakeRenderer());

        lastUpdateMillis = TimeUtils.millis();

    }

    @Override
    public void render () {
        // Updates

        if (TimeUtils.millis() - lastUpdateMillis < 75) {
            return;
        }

        lastUpdateMillis = TimeUtils.millis();

        // Draw
        Gdx.gl.glClearColor(51/255f, 51/255f, 51/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        arena.update();
        renderer.draw();
    }
}
