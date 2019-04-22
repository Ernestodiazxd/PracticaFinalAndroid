package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Arrays;

public class GameScreen extends ScreenBase {
    SpriteBatch batch;
    int altura,amplada;
    TextureRegion region;
    TextureAtlas atlas;
    TextureRegion anim;
    TextureRegion[] frames,frames2;
    Animation animacio;
    float duracio;
    BitmapFont font;




    public GameScreen(Game joc) {
        super(joc);

        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();
        atlas=joc.getAtlas();
        font=new BitmapFont();

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
        font.setColor(Color.BLACK);

        /*
        duracio += Gdx.graphics.getDeltaTime();
        anim= (TextureRegion) animacio.getKeyFrame(duracio,true);
        */

        batch.begin();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        font.draw(batch,"GameScreen",(amplada/2)-100,(altura/2)+100);

       // batch.draw(anim,50,50);


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
        atlas.dispose();

    }
}
