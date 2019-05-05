package com.mygdx.game.Actors.Buttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ButtonEntendido extends Actor {
    TextureAtlas atlas;
    TextureRegion region;

    public ButtonEntendido() {
        atlas= new TextureAtlas("fitxerAtlasExtra.atlas");
        region = atlas.findRegion("botonTutorial");
        setSize(region.getRegionWidth(),region.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }

}
