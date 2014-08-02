package com.hakrx.battlesnakes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakrx.battlesnakes.ScreenProperties;

public class PauseScreen implements Screen {

    static String pausedText = "Paused";

    BitmapFont font;
    SpriteBatch spriteBatch;
    Camera camera;
    Viewport viewport;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(51/255f, 51/255f, 51/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(camera.projection);
        spriteBatch.setTransformMatrix(camera.view);

        BitmapFont.TextBounds bounds = font.getBounds(pausedText);

        spriteBatch.begin();
        font.draw(spriteBatch, pausedText, ScreenProperties.VIRTUAL_WIDTH/2 - bounds.width/2, ScreenProperties.VIRTUAL_HEIGHT/2 - bounds.height/2);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void show() {
        font = new BitmapFont();
        font.setScale(5f);

        spriteBatch = new SpriteBatch();

        camera = new OrthographicCamera(ScreenProperties.VIRTUAL_WIDTH, ScreenProperties.VIRTUAL_HEIGHT);
        viewport = new FitViewport(ScreenProperties.VIRTUAL_WIDTH, ScreenProperties.VIRTUAL_HEIGHT, camera);
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
    public void dispose() {
        font.dispose();
        spriteBatch.dispose();
    }
}
