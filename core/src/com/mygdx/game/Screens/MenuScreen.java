package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Actors.Decoracion.ActorMenuBackground;
import com.mygdx.game.Actors.Decoracion.PalabraStart;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.ScreenBase;

public class MenuScreen extends ScreenBase {

    GhostKiller joc;
    SpriteBatch batch;
    int altura,amplada;
    Music music;
    Stage esc;
    Actor menuActor,start;
    public static int contador;
    TutorialScreen t;




    public MenuScreen(GhostKiller joc) {
        super(joc);
        this.joc=joc;
        this.t=new TutorialScreen(joc);

        altura=joc.getAltura();
        amplada=joc.getAmplada();
        batch=joc.getBatch();

        music = Gdx.audio.newMusic(Gdx.files.internal("data/soundmenu.mp3"));
        music.play();

        esc = new Stage(new ScreenViewport());

        menuActor=new ActorMenuBackground();
        start=new PalabraStart();

        menuActor.setPosition(0,0);
        start.setPosition(altura/2+10,altura/2+500);

        esc.addActor(menuActor);
        esc.addActor(start);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (contador==100){
            contador=0;

        }


        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        delta = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        if (contador<50){
            start.addAction(Actions.show());
        }else if  (contador>50){
            start.addAction(Actions.hide());
        }


        esc.act(delta);
        esc.draw();

        contador++;


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
        esc.dispose();



    }
}
