package com.mygdx.game.Actors.Decoracion;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

//Clase actor del la frase per començar en MenuScreen
public class PalabraStart extends Actor {
    //inicialitzem les variables
    TextureAtlas atlas;
    TextureRegion region;

    public PalabraStart() {
        //busquem a l'atlas el que volem
        atlas= new TextureAtlas("fitxerAtlasExtra.atlas");
        region = atlas.findRegion("start");
        setSize(region.getRegionWidth(),region.getRegionHeight());
    }

    //ho dibuixem
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}
