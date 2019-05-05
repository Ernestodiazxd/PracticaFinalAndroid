package com.mygdx.game.Actors.Decoracion;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

//Clase actor del marc inferior en GameScreen
public class ActorMarco extends Actor {

    //inicialitzem les variables
    TextureAtlas atlas;
    TextureRegion region;

    public ActorMarco() {
        //busquem a l'atlas el que volem
        atlas=new TextureAtlas("fitxerAtlasStages.atlas");
        region=atlas.findRegion("marco");
        setSize(region.getRegionWidth(),region.getRegionHeight()+150);
    }

    //ho dibuixem
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}
