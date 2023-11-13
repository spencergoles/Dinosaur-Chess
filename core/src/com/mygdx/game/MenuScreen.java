package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import com.badlogic.gdx.utils.viewport.ScreenViewport;



public class MenuScreen implements Screen {
    private final SpriteBatch batch;
    private final Music menuMusic;
    private final TextButton playButton;
    private final TextButton howToPlayButton;
    private final TextButton settingsButton;
    private final Stage stage;

    public MenuScreen(final SpriteBatch batch, final Music menuMusic) {
        this.batch = batch;
        this.menuMusic = menuMusic;

        // Set up the stage for UI
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Initialize buttons
        float buttonWidth = 200;
        float buttonHeight = 50;
        float buttonSpacing = 20;
        float centerX = Gdx.graphics.getWidth() / 2f;
        float centerY = Gdx.graphics.getHeight() / 2f - 100;

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = new BitmapFont();
        buttonStyle.font.setColor(Color.BLACK);

        playButton = new TextButton("Play Game", buttonStyle);
        playButton.setSize(buttonWidth, buttonHeight);
        playButton.setPosition(centerX - buttonWidth / 2, centerY);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                menuMusic.stop(); // Stop current music
                DinosaurChess.game.setScreen(new PlayGameScreen(batch));
            }
        });


        howToPlayButton = new TextButton("How to Play", buttonStyle);
        howToPlayButton.setSize(buttonWidth, buttonHeight);
        howToPlayButton.setPosition(centerX - buttonWidth / 2, centerY - buttonHeight - buttonSpacing);
        howToPlayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                DinosaurChess.game.setScreen(new HowToPlayScreen(batch, menuMusic));
            }
        });

        settingsButton = new TextButton("Settings", buttonStyle);
        settingsButton.setSize(buttonWidth, buttonHeight);
        settingsButton.setPosition(centerX - buttonWidth / 2, centerY - 2 * (buttonHeight + buttonSpacing));
        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                DinosaurChess.game.setScreen(new SettingsScreen(batch, menuMusic));
            }
        });

        // Add buttons to the stage
        stage.addActor(playButton);
        stage.addActor(howToPlayButton);
        stage.addActor(settingsButton);
    }

    @Override
    public void show() {
        // Called when this screen is set as the current screen.
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLUE);

        batch.begin();

        // Your menu screen rendering code goes here

        // Draw the title "Dinosaur Chess" centered
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(3);

        GlyphLayout layout = new GlyphLayout(font, "Dinosaur Chess");
        float textX = (Gdx.graphics.getWidth() - layout.width) / 2f;
        float textY = Gdx.graphics.getHeight() - layout.height;
        font.draw(batch, layout, textX, textY);

        batch.end();

        // Draw the stage (buttons)
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}




