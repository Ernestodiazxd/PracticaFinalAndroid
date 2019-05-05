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
import com.mygdx.game.Actors.Buttons.ActorDownButton;
import com.mygdx.game.Actors.Decoracion.ActorGameBackground;
import com.mygdx.game.Actors.Buttons.ActorLeftButton;
import com.mygdx.game.Actors.Decoracion.ActorHeart;
import com.mygdx.game.Actors.Decoracion.ActorMarco;
import com.mygdx.game.Actors.ActorPJ;
import com.mygdx.game.Actors.Buttons.ActorRightButton;
import com.mygdx.game.Actors.Buttons.ActorUpButton;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.GhostPositions;
import com.mygdx.game.ScreenBase;

//Pantalla del joc
public class GameScreen extends ScreenBase {
    //inicialitzar variables
    GhostKiller joc;
    private SpriteBatch batch;
    public int altura,amplada;
    private Stage esc;
    private Actor actorScreen,up,down,left,right,actorMarco;
    private Music music,death,sound;
    ActorGhost ghost;
    ActorPJ pj;
    ActorHeart heart1,heart2,heart3;
    private GhostPositions[] positions = new GhostPositions[4];
    public static int randomposition=0;
    public static int randomcolor=0;
    public static int contador=0;
    GameOver o;



    //consturctor per emplenar les variables
    public GameScreen(GhostKiller joc) {
        super(joc);
        this.joc=joc;
        this.o=new GameOver(joc);
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


        //inicialitzar l'Stage
        esc = new Stage(new ScreenViewport());

        //innicialitzar els Actors
        pj=new ActorPJ();
        actorScreen=new ActorGameBackground();
        up=new ActorUpButton();
        down=new ActorDownButton();
        left=new ActorLeftButton();
        right=new ActorRightButton();
        actorMarco=new ActorMarco();
        ghost=new ActorGhost();
        heart1 = new ActorHeart();
        heart2=new ActorHeart();
        heart3=new ActorHeart();


        //emplenar l'array de posicions dels enemics
        positions[0]=new GhostPositions(amplada/2-40,altura+150);
        positions[1]=new GhostPositions(amplada/2-40,(int)actorMarco.getY()+650);
        positions[2]=new GhostPositions(amplada,altura/2+300);
        positions[3]=new GhostPositions(-100,altura/2+300);


        //lloc aleatori per la printació dels enemics
        randomposition=(int)(Math.random()*4);


        //Lloc on volem printar els actors
        pj.setPosition(amplada/2-200,altura/2+150);

        actorScreen.setPosition(0,0);
        up.setPosition(410,415);
        down.setPosition(410,25);
        left.setPosition(140,220);
        right.setPosition(675,220);

        ghost.setPosition(positions[0].getX(),positions[0].getY());
        actorMarco.setPosition(0,0);

        heart1.setPosition(amplada-280,altura-100);
        heart2.setPosition(amplada-190,altura-100);
        heart3.setPosition(amplada-100,altura-100);


        //Incloure els actos a l'Stage
        esc.addActor(actorScreen);
        esc.addActor(pj);
        esc.addActor(ghost);
        esc.addActor(actorMarco);
        esc.addActor(up);
        esc.addActor(down);
        esc.addActor(left);
        esc.addActor(right);
        esc.addActor(heart1);
        esc.addActor(heart2);
        esc.addActor(heart3);



        //inicialitzar la musica que utilitzarem
        music = Gdx.audio.newMusic(Gdx.files.internal("data/battlemusic.mp3"));
        death = Gdx.audio.newMusic(Gdx.files.internal("data/death.mp3"));
        sound = Gdx.audio.newMusic(Gdx.files.internal("data/sound.mp3"));



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        //if per controlar la printació de enemics
        if (contador%100==1){

            ghost = new ActorGhost();
            randomposition = (int) (Math.random() * 4);
            ghost.setPosition(positions[randomposition].getX(), positions[randomposition].getY());


            esc.addActor(ghost);
        }


        music.play();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        //afegir listeners als botons que realitzen varies accions
        Gdx.input.setInputProcessor(esc);

        //mirar cap amunt
        up.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Up");
                pj.goUp();
                return true;
            }
        });

        //mirar cap avall
        down.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Down");
                pj.goDown();
                return true;
            }
        });

        //mirar a l'esquerra
        left.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Left");
                pj.goLeft();
                return true;
            }
        });

        //mirar a la dreta
        right.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("tag","Right");
                pj.goRight();
                return true;
            }


        });


        //printar l'Stage
        esc.act(delta);
        esc.draw();



        //accions que realitzen els enemics
        SequenceAction seq = new SequenceAction();
        seq.addAction(Actions.moveTo(500,1313,4.5f));
        seq.addAction(Actions.hide());
        ghost.addAction(seq);


        //coordenades per controrlar les colisions
        ghost.pasarCoordenades((int)ghost.getX(),(int)ghost.getY());


        //if per les colisions
        //si hi ha colisio, es realitzen x accions
        if (pj.collides(ghost.getBounds())) {

            /*
            if (!(pj.getDirection()==randomposition)){
            }
            */
            SequenceAction seq2 = new SequenceAction();
            seq2.addAction(Actions.moveTo(20,0,0.5f));
            seq2.addAction(Actions.moveTo(0,0,0.5f));
            seq2.addAction(Actions.moveTo(20,0,0.5f));
            seq2.addAction(Actions.moveTo(0,0,0.5f));
            actorScreen.addAction(seq2);
            sound.play();

            //reduir en 1 la vida del jugador
            pj.setLife(pj.getLife() - 1);

        }
        contador++;

        //depentent de les vides, es printen x cors
        if (pj.getLife()==2) {
            heart1.addAction(Actions.hide());

        }else

        if (pj.getLife()==1) {
            heart2.addAction(Actions.hide());

        }else

        if(pj.getLife()==0){
            heart3.addAction(Actions.hide());
        }

        else if (pj.getLife()==-1){
            death.play();
            joc.setScreen(o);
        }

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

    //parar la musica al cambiar de pantalla
    @Override
    public void hide() {
    music.stop();
    }

    //netejar la memoria
    @Override
    public void dispose() {
        music.dispose();
        batch.dispose();
        esc.dispose();

    }
}
