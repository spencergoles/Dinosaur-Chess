package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;


public class TitleScreen implements Screen {
    private final SpriteBatch batch;
    private final Texture img;
    private final Music menuMusic;

    private float elapsedTime = 0f;

    public TitleScreen(SpriteBatch batch, Music menuMusic) {
        this.batch = batch;
        this.img = new Texture("titleArt.png");
        this.menuMusic = menuMusic;
    }

    @Override
    public void show() {
        // Called when this screen is set as the current screen.
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.YELLOW);

        elapsedTime += delta;

        batch.begin();

        float halfHeight = Gdx.graphics.getHeight() / 2f;
        float aspectRatio = (float) img.getWidth() / img.getHeight();
        float halfWidth = halfHeight * aspectRatio;

        float x = (Gdx.graphics.getWidth() - halfWidth) / 2f;
        float y = (Gdx.graphics.getHeight() - halfHeight) / 2f;

        batch.draw(img, x, y, halfWidth, halfHeight);

        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(3);

        GlyphLayout layout = new GlyphLayout(font, "Dinosaur Chess");
        float textX = (Gdx.graphics.getWidth() - layout.width) / 2f;
        float textY = y - layout.height * 2;
        font.draw(batch, layout, textX, textY);

        batch.end();

        // Switch to MenuScreen after 4 seconds
        if (elapsedTime >= 4f) {
            DinosaurChess.game.setScreen(new MenuScreen(batch, menuMusic));
        }
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
        img.dispose();
    }
}

