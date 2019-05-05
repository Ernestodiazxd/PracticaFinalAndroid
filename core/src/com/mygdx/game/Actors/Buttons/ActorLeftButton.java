package com.mygdx.game.Actors.Buttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

//Actor dle Button de mirar cap a l'esquerra
public class ActorLeftButton extends Actor {

    //inicialitzem les variables que necesitarem
    TextureAtlas atlas;
    TextureRegion region;
    TextureRegion[] frames;


    public ActorLeftButton() {
        //busquem a l'atlas el que volem
        atlas = new TextureAtlas("fitxerAtlas.atlas");
        region = atlas.findRegion("Left");

        setSize(250, 250);

        //ja que el botó te 2 estats (encés/apagat) l'atlas te dos sprites, el que fem aqui es separarlos
        TextureRegion[][] temp = region.split(region.getRegionWidth() / 2, region.getRegionHeight());
        frames = new TextureRegion[(temp.length * temp[0].length)];

        //els guardem a un array
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                frames[index++] = temp[i][j];
            }
        }


    }

    //dibuixem el botó
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(frames[0], getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

}
