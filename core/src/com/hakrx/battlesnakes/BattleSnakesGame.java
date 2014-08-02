package com.hakrx.battlesnakes;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.hakrx.battlesnakes.screens.GameScreen;
import com.hakrx.battlesnakes.screens.PauseScreen;

public class BattleSnakesGame extends Game {

    GameScreen gameScreen;
    PauseScreen pauseScreen;
    GameState state;
    int previousWidth;
    int previousHeight;

    @Override
    public void create() {
        gameScreen = new GameScreen(this);
        pauseScreen = new PauseScreen();
        state = GameState.RUNNING;
        setScreen(gameScreen);

        previousWidth = Gdx.graphics.getWidth();
        previousHeight = Gdx.graphics.getHeight();
    }

    @Override
    public void render() {
        if (Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)) {
            if (!Gdx.graphics.isFullscreen()) {
                previousWidth = Gdx.graphics.getWidth();
                previousHeight = Gdx.graphics.getHeight();

                Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, true);
            }

            else {
                Gdx.graphics.setDisplayMode(previousWidth, previousHeight, false);
            }
        }

        super.render();
    }

    public GameState getState() {
        return state;
    }

    public void pauseGame() {
        state = GameState.PAUSED;
        setScreen(pauseScreen);
    }

    public void resumeGame() {
        state = GameState.RUNNING;
        setScreen(gameScreen);
    }
}
