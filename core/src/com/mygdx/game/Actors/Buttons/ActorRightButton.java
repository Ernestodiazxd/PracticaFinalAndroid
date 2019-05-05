package com.mygdx.game.Actors.Buttons;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorRightButton extends Actor {

    TextureAtlas atlas;
    TextureRegion region;
    TextureRegion[] frames;


    public ActorRightButton() {
        atlas = new TextureAtlas("fitxerAtlas.atlas");
        region = atlas.findRegion("Right");

        setSize(250, 250);

        TextureRegion[][] temp = region.split(region.getRegionWidth() / 2, region.getRegionHeight());
        frames = new TextureRegion[(temp.length * temp[0].length)];

        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                frames[index++] = temp[i][j];
            }
        }


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(frames[0], getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

}
