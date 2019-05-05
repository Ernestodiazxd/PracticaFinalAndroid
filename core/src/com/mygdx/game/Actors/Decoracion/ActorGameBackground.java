package com.mygdx.game.Actors.Decoracion;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

//Clase actor del background en GameScreen
public class ActorGameBackground extends Actor {
    //inicialitzem les variables
    TextureAtlas atlas;
    TextureRegion region;

    public ActorGameBackground() {
        //busquem a l'atlas el que volem
        atlas=new TextureAtlas("fitxerAtlasStages.atlas");
        region=atlas.findRegion("back");
        setSize(region.getRegionWidth(),region.getRegionHeight()+150);
    }

    //dibuixem el background
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }

}
