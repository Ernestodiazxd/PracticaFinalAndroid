package com.mygdx.game.Actors.Buttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

//Button per a seguir despres del tutorial
public class ButtonEntendido extends Actor {
   //inicialitzem les variables que necesitarem
    TextureAtlas atlas;
    TextureRegion region;

    public ButtonEntendido() {
        //busquem a l'atlas el que volem
        atlas= new TextureAtlas("fitxerAtlasExtra.atlas");
        region = atlas.findRegion("botonTutorial");
        setSize(region.getRegionWidth(),region.getRegionHeight());
    }

    //dibuixem el botó
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }

}
