package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameScreen extends ScreenBase {
    SpriteBatch batch;
    int altura,amplada;
    BitmapFont font;
    Stage esc;
    Actor actorScreen,actorLink;
    Music music;




    public GameScreen(Game joc) {
        super(joc);

        //font=new BitmapFont();
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


        esc = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(esc);

        actorScreen=new ActorGameBackground();
        actorLink=new ActorPJ();


        actorLink.setPosition(amplada/2-200,altura/2);
        actorScreen.setPosition(0,0);
        esc.addActor(actorScreen);
        esc.addActor(actorLink);

       music = Gdx.audio.newMusic(Gdx.files.internal("data/battlemusic.mp3"));





    }

    @Override
    public void show() {

        /*
        region=atlas.findRegion("Link");
        TextureRegion[][]temp=region.split(region.getRegionWidth()/7,region.getRegionHeight()/4);
        frames=new TextureRegion[(temp.length*temp[0].length)];

        int index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                frames[index++]=temp[i][j];
            }
        }

        frames2= Arrays.copyOf(frames,frames.length-4);
        for(int i=0;i<frames2.length;i++){
            frames2[i]=frames[i];
        }

        animacio=new Animation(0.15f,frames2);
        */

    }

    @Override
    public void render(float delta) {
        //font.setColor(Color.BLACK);

        /*
        duracio += Gdx.graphics.getDeltaTime();
        anim= (TextureRegion) animacio.getKeyFrame(duracio,true);
        */

        //font.draw(batch,"GameScreen",(amplada/2)-100,(altura/2)+100);
        // batch.draw(anim,50,50);

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
