package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Actors.Decoracion.ActorMenuBackground;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.ScreenBase;

public class MenuScreen extends ScreenBase {

    SpriteBatch batch;
    int altura,amplada;
    Music music,playmusic;
    Stage esc;
    Actor menuActor;




    public MenuScreen(GhostKiller joc) {
        super(joc);

        altura=joc.getAltura();
        amplada=joc.getAmplada();
        batch=joc.getBatch();

        music = Gdx.audio.newMusic(Gdx.files.internal("data/soundmenu.mp3"));
        music.play();

        playmusic= Gdx.audio.newMusic(Gdx.files.internal("data/start.mp3"));

        esc = new Stage(new ScreenViewport());

        menuActor=new ActorMenuBackground();

        esc.addActor(menuActor);




    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
        music.stop();

    }

    @Override
    public void dispose() {
        music.dispose();
        batch.dispose();

    }
}
