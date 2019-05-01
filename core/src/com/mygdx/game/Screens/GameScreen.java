package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.mygdx.game.Actors.Buttons.ActorAttackButton;
import com.mygdx.game.Actors.Buttons.ActorDownButton;
import com.mygdx.game.Actors.Decoracion.ActorGameBackground;
import com.mygdx.game.Actors.Buttons.ActorLeftButton;
import com.mygdx.game.Actors.Decoracion.ActorMarco;
import com.mygdx.game.Actors.ActorPJ;
import com.mygdx.game.Actors.Buttons.ActorRightButton;
import com.mygdx.game.Actors.Buttons.ActorSPButton;
import com.mygdx.game.Actors.Buttons.ActorUpButton;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.ScreenBase;


public class GameScreen extends ScreenBase {
    private SpriteBatch batch;
    public int altura,amplada;
    private Stage esc;
    private Actor actorScreen,actorLink,actorAttackButton, actorSpButton, up,down,left,right,actorMarco;
    private Music music;
    ActorPJ pj;

    public GameScreen(GhostKiller joc) {
        super(joc);
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


        esc = new Stage(new ScreenViewport());

        pj=new ActorPJ();
        actorLink=new ActorPJ();
        actorScreen=new ActorGameBackground();
        actorAttackButton=new ActorAttackButton();
        actorSpButton= new ActorSPButton();
        up=new ActorUpButton();
        down=new ActorDownButton();
        left=new ActorLeftButton();
        right=new ActorRightButton();
        actorMarco=new ActorMarco();



        actorLink.setPosition(amplada/2-200,altura/2+75);
        actorScreen.setPosition(0,0);
        actorAttackButton.setPosition(600,50);
        actorSpButton.setPosition(850,300);
        up.setPosition(210,350);
        down.setPosition(210,50);
        left.setPosition(70,200);
        right.setPosition(345,200);
        actorMarco.setPosition(0,0);


        esc.addActor(actorScreen);
        esc.addActor(actorLink);
        esc.addActor(actorMarco);
        esc.addActor(actorAttackButton);
        esc.addActor(actorSpButton);
        esc.addActor(up);
        esc.addActor(down);
        esc.addActor(left);
        esc.addActor(right);


        music = Gdx.audio.newMusic(Gdx.files.internal("data/battlemusic.mp3"));


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        music.play();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.input.setInputProcessor(esc);
        up.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Up");
                pj.goUp();
                return true;
            }
        });

        down.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Down");
                pj.goDown();
                return true;
            }
        });

        left.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Left");
                pj.goLeft();
                return true;
            }
        });

        right.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Right");
                pj.goRight();
                return true;
            }


        });

        actorSpButton.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","SP");
                pj.goSP();
                return true;
            }



        });


        actorAttackButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                if (pj.getDirection()==0){
                    Gdx.app.log("tag","Attack");
                    pj.goAttack();
                }
                if (pj.getDirection()==1) {
                    Gdx.app.log("tag", "AttackUp");
                    pj.goAttackUp();
                }

                if (pj.getDirection()==2) {
                    Gdx.app.log("tag", "AttackRight");
                    pj.goAttackRight();
                }

                if (pj.getDirection()==3) {
                    Gdx.app.log("tag", "AttackLeft");
                    pj.goAttackLeft();
                }
                return true;
            }

        });

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
        music.dispose();
        batch.dispose();
        esc.dispose();


    }
}
