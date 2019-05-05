package com.mygdx.game.Actors.Decoracion;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

//Clase actor de les vides en GameScreen
public class ActorHeart extends Actor {

    //inicialitzem les variables
    TextureAtlas atlas;
    TextureRegion region;

    public ActorHeart() {
        //busquem a l'atlas el que volem
        atlas=new TextureAtlas("fitxerAtlasExtra.atlas");
        region = atlas.findRegion("heart");
        setSize(75,70);
    }

    //dibuixem el heart
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}
