package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class PlayGameScreen implements Screen {
    private final SpriteBatch batch;
    private final Music playGameMusic;

    public PlayGameScreen(SpriteBatch batch) {
        this.batch = batch;
        this.playGameMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/music/menu.mp3"));
        this.playGameMusic.setLooping(true);
        this.playGameMusic.setVolume(0.5f);
        this.playGameMusic.play();
    }

    @Override
    public void show() {
        // Called when this screen is set as the current screen.
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.RED);

        batch.begin();

        // Your PlayGameScreen rendering code goes here

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
        playGameMusic.dispose();
        // Dispose of any additional resources when the screen is no longer needed
    }
}


