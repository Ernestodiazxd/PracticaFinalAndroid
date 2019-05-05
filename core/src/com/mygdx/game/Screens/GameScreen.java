package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import com.mygdx.game.Actors.ActorGhost;
import com.mygdx.game.Actors.Buttons.ActorAttackButton;
import com.mygdx.game.Actors.Buttons.ActorDownButton;
import com.mygdx.game.Actors.Decoracion.ActorGameBackground;
import com.mygdx.game.Actors.Buttons.ActorLeftButton;
import com.mygdx.game.Actors.Decoracion.ActorHeart;
import com.mygdx.game.Actors.Decoracion.ActorMarco;
import com.mygdx.game.Actors.ActorPJ;
import com.mygdx.game.Actors.Buttons.ActorRightButton;
import com.mygdx.game.Actors.Buttons.ActorSPButton;
import com.mygdx.game.Actors.Buttons.ActorUpButton;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.GhostPositions;
import com.mygdx.game.ScreenBase;


public class GameScreen extends ScreenBase {
    GhostKiller joc;
    private SpriteBatch batch;
    public int altura,amplada;
    private Stage esc;
    private Actor actorScreen,actorLink,actorAttackButton, actorSpButton, up,down,left,right,actorMarco,actorGhost;
    private Music music;
    ActorPJ pj;
    ActorHeart heart1,heart2,heart3;
    private GhostPositions[] positions = new GhostPositions[4];
    public static int randomposition=0;
    public static int randomcolor=0;
    public static int contador=0;



    public GameScreen(GhostKiller joc) {
        super(joc);
        this.joc=joc;
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


        esc = new Stage(new ScreenViewport());

        pj=new ActorPJ();
        actorLink=new ActorPJ();
        actorScreen=new ActorGameBackground();
        /*
        actorAttackButton=new ActorAttackButton();
        actorSpButton= new ActorSPButton();
        */
        up=new ActorUpButton();
        down=new ActorDownButton();
        left=new ActorLeftButton();
        right=new ActorRightButton();
        actorMarco=new ActorMarco();
        actorGhost=new ActorGhost();
        heart1 = new ActorHeart();
        heart2=new ActorHeart();
        heart3=new ActorHeart();


        positions[0]=new GhostPositions(amplada/2-40,altura+150);
        positions[1]=new GhostPositions(amplada/2-40,(int)actorMarco.getY()+650);
        positions[2]=new GhostPositions(amplada,altura/2+300);
        positions[3]=new GhostPositions(-100,altura/2+300);


        randomposition=(int)(Math.random()*4);



        actorLink.setPosition(amplada/2-200,altura/2+150);
        actorScreen.setPosition(0,0);

        /*
        actorAttackButton.setPosition(600,50);
        actorSpButton.setPosition(850,300);

        up.setPosition(210,350);
        down.setPosition(210,50);
        left.setPosition(70,200);
        right.setPosition(345,200);

        */

        up.setPosition(410,415);
        down.setPosition(410,25);
        left.setPosition(140,220);
        right.setPosition(675,220);

        actorGhost.setPosition(positions[0].getX(),positions[0].getY());
        actorMarco.setPosition(0,0);

        heart1.setPosition(amplada-280,altura-100);
        heart2.setPosition(amplada-190,altura-100);
        heart3.setPosition(amplada-100,altura-100);


        esc.addActor(actorScreen);
        esc.addActor(actorLink);
        esc.addActor(actorGhost);
        esc.addActor(actorMarco);
        /*
        esc.addActor(actorAttackButton);
        esc.addActor(actorSpButton);
        */
        esc.addActor(up);
        esc.addActor(down);
        esc.addActor(left);
        esc.addActor(right);
        esc.addActor(heart1);
        esc.addActor(heart2);
        esc.addActor(heart3);



        music = Gdx.audio.newMusic(Gdx.files.internal("data/battlemusic.mp3"));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if (contador%100==1){

            actorGhost = new ActorGhost();
            randomposition = (int) (Math.random() * 4);
            //randomcolor = (int) (Math.random() * 4);
            actorGhost.setPosition(positions[randomposition].getX(), positions[randomposition].getY());

            /*
            if (randomcolor==0){

                Gdx.app.log("tag","RED");
                actorGhost.addAction(Actions.color(com.badlogic.gdx.graphics.Color.RED,1));
            }

            else if (randomcolor==1) {
                Gdx.app.log("tag", "BLUE");
                actorGhost.addAction(Actions.color(com.badlogic.gdx.graphics.Color.BLUE,1));
            }

            else if (randomcolor==2) {
                Gdx.app.log("tag", "ORANGE");
                actorGhost.addAction(Actions.color(com.badlogic.gdx.graphics.Color.ORANGE,1));
            }

           else if (randomcolor==3) {
                Gdx.app.log("tag", "PINK");
                actorGhost.addAction(Actions.color(com.badlogic.gdx.graphics.Color.PINK,1));
            }
            */

            esc.addActor(actorGhost);
        }



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

        /*

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

        */

        SequenceAction seq = new SequenceAction();
        seq.addAction(Actions.moveTo(500,1313,4));
        seq.addAction(Actions.hide());
        actorGhost.addAction(seq);


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

    }

    @Override
    public void dispose() {
        music.dispose();
        batch.dispose();
        esc.dispose();

    }
}
