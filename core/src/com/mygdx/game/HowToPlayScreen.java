package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;



public class HowToPlayScreen implements Screen {
    private final SpriteBatch batch;
    private final Music menuMusic;

    public HowToPlayScreen(SpriteBatch batch, Music menuMusic) {
        this.batch = batch;
        this.menuMusic = menuMusic;
    }

    @Override
    public void show() {
        // Called when this screen is set as the current screen.
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GREEN);

        batch.begin();

        // Your HowToPlayScreen rendering code goes here

        batch.end();

        // Handle screen transitions or interactions here
    }

    @Override
    public void resize(int width, int height) {
        // Called when the screen size is changed.
    }

    @Override
    public void pause() {
        // Called when the game is paused.
    }

    @Override
    public void resume() {
        // Called when the game is resumed.
    }

    @Override
    public void hide() {
        // Called when this screen is no longer the current screen.
    }

    @Override
    public void dispose() {
        // Dispose of any resources when the screen is no longer needed
    }
}


