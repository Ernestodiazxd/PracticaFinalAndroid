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
import com.mygdx.game.Actors.Buttons.ActorDownButton;
import com.mygdx.game.Actors.Buttons.ActorLeftButton;
import com.mygdx.game.Actors.Buttons.ActorRightButton;
import com.mygdx.game.Actors.Buttons.ActorUpButton;
import com.mygdx.game.Actors.Buttons.ButtonEntendido;
import com.mygdx.game.Actors.Decoracion.ActorGameBackground;
import com.mygdx.game.Actors.Decoracion.ActorHeart;
import com.mygdx.game.Actors.Decoracion.ActorMarco;
import com.mygdx.game.Actors.Decoracion.VentanaTutorial;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.ScreenBase;

//Pantalla del tutorial
public class TutorialScreen extends ScreenBase {
    //inicialitzar variables
    GhostKiller joc;
    private SpriteBatch batch;
    public int altura,amplada;
    private Stage esc;
    private Actor actorScreen,up,down,left,right,actorMarco;
    private ActorHeart heart1,heart2,heart3;
    private VentanaTutorial tutorial;
    private ButtonEntendido entendido;
    Music playmusic;
    GameScreen g;


    //Constructor per emplenar les variables
    public TutorialScreen(GhostKiller joc) {
        super(joc);
        this.g=new GameScreen(joc);
        this.joc=joc;
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();
        playmusic= Gdx.audio.newMusic(Gdx.files.internal("data/start.mp3"));


        //inicialitzar l'Stage
        esc = new Stage(new ScreenViewport());

        //inicialitzar els actors
        actorScreen=new ActorGameBackground();
        up=new ActorUpButton();
        down=new ActorDownButton();
        left=new ActorLeftButton();
        right=new ActorRightButton();
        actorMarco=new ActorMarco();
        heart1 = new ActorHeart();
        heart2=new ActorHeart();
        heart3=new ActorHeart();

        tutorial=new VentanaTutorial();
        entendido=new ButtonEntendido();


        //Lloc on volem printar els actors
        actorScreen.setPosition(0,0);
        up.setPosition(410,415);
        down.setPosition(410,25);
        left.setPosition(140,220);
        right.setPosition(675,220);
        actorMarco.setPosition(0,0);

        heart1.setPosition(amplada-280,altura-100);
        heart2.setPosition(amplada-190,altura-100);
        heart3.setPosition(amplada-100,altura-100);

        tutorial.setPosition(25,400);
        entendido.setPosition(250,520);


        //Incloure els actos a l'Stage
        esc.addActor(actorScreen);
        esc.addActor(actorMarco);

        esc.addActor(up);
        esc.addActor(down);
        esc.addActor(left);
        esc.addActor(right);
        esc.addActor(heart1);
        esc.addActor(heart2);
        esc.addActor(heart3);
        esc.addActor(tutorial);
        esc.addActor(entendido);

    }

    @Override
    public void show() {

    }


    //metode que printa en pantalla en bucle
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //al el botó, cambiem de pantalla
        Gdx.input.setInputProcessor(esc);
        entendido.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                playmusic.play();
                joc.setScreen(g);
                return true;
            }
        });

        //printar l'Stage
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

    //netejar la memoria
    @Override
    public void dispose() {

        batch.dispose();
        esc.dispose();

    }
}
