package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.ScreenBase;

//pantalla de Fi del Joc
public class GameOver extends ScreenBase {

    //inicialitzar variables
    GhostKiller joc;
    private SpriteBatch batch;
    public int altura,amplada;

    Texture texture;
    TextureRegion region;

    //Constructor per emplenar les variables
    public GameOver(GhostKiller joc) {
        super(joc);
        this.joc=joc;
        batch=joc.getBatch();
        altura=joc.getAltura();
        amplada=joc.getAmplada();


        //Buscar el que necesitem a l'atlas
        texture=new Texture("gameover.png");
        region=new TextureRegion(texture,0,0,texture.getWidth(),texture.getHeight()+150);


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

        batch.begin();

        batch.draw(region,0,0);

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

    //netejar la memoria
    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();

    }
}
