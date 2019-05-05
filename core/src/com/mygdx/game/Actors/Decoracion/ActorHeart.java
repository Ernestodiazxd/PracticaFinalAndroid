package com.mygdx.game.Actors.Decoracion;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorHeart extends Actor {

    TextureAtlas atlas;
    TextureRegion region;

    public ActorHeart() {
        atlas=new TextureAtlas("fitxerAtlasExtra.atlas");
        region = atlas.findRegion("heart");
        setSize(75,70);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}
