package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.Font;

public class MenuScreen extends ScreenBase {

    BitmapFont font;
    SpriteBatch batch;
    int altura,amplada;
    Stage esc;
    Actor actor;
    Music music;




    public MenuScreen(Game joc) {
        super(joc);

        font=new BitmapFont();
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


        esc = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(esc);

        actor=new ActorMenuBackground();

        actor.setPosition(0,0);
        esc.addActor(actor);

        music = Gdx.audio.newMusic(Gdx.files.internal("data/battlemusic.mp3"));



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {


        /*font.setColor(Color.WHITE);

        batch.begin();
        font.draw(batch,"MenuScreen",(amplada/2),(altura/2)-100);

        batch.end();
        */

        music.play();
        delta = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        esc.act(delta);
        esc.draw();






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
