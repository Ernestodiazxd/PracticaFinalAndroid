package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends ScreenBase {

    BitmapFont font;
    SpriteBatch batch;
    int altura,amplada;




    public MenuScreen(Game joc) {
        super(joc);

        font=new BitmapFont();
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        font.setColor(Color.BLACK);

        Gdx.app.log("myTag","Render pantalla");

        batch.begin();
        font.draw(batch,"MenuScreen",(amplada/2)-100,(altura/2)+100);
        batch.end();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();

    }
}
