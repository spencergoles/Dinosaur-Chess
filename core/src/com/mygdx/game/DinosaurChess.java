package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DinosaurChess extends Game {
    public static DinosaurChess game;
    private SpriteBatch batch;
    private Music menuMusic;

    @Override
    public void create() {
        game = this;
        batch = new SpriteBatch();

        // Create the shared music instance
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/music/menu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.setVolume(0.5f);
        menuMusic.play();

        // Set the title screen as the initial screen
        setScreen(new TitleScreen(batch, menuMusic));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        menuMusic.dispose();
    }
}





/*
public class DinosaurChess extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Music menuMusic;

    @Override
    public void create () {
        batch = new SpriteBatch();
        img = new Texture("titleArt.png");
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/music/menu.mp3"));
        menuMusic.setLooping(true);
        menuMusic.setVolume(0.5f); // Adjust the volume as needed
        menuMusic.play();
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.YELLOW); // Set the background color to yellow

        batch.begin();

        // Calculate the new size of the image (half of the screen height and proportional)
        float halfHeight = Gdx.graphics.getHeight() / 2f;
        float aspectRatio = (float) img.getWidth() / img.getHeight();
        float halfWidth = halfHeight * aspectRatio;

        // Center the image on the screen
        float x = (Gdx.graphics.getWidth() - halfWidth) / 2f;
        float y = (Gdx.graphics.getHeight() - halfHeight) / 2f;

        // Print float values to the system console
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        // Draw the resized image
        batch.draw(img, x, y, halfWidth, halfHeight);

        // Set up a BitmapFont for drawing text
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(3); // Adjust the scale as needed (increase for bigger text)

        // Draw the text "Dinosaur Chess" centered below the image
        GlyphLayout layout = new GlyphLayout(font, "Dinosaur Chess");
        float textX = (Gdx.graphics.getWidth() - layout.width) / 2f;
        float textY = y - layout.height * 2; // Adjust this value as needed
        font.draw(batch, layout, textX, textY);

        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
        menuMusic.dispose();
    }
}


*/