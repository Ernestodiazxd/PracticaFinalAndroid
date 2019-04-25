package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPJ extends Actor {

    TextureAtlas atlas;
    TextureRegion region;
    TextureRegion[] frames;
    Animation animacio;
    float duracio;
    TextureRegion anim;

    public ActorPJ() {
        atlas=new TextureAtlas("fitxerAtlas.atlas");
        region=atlas.findRegion("LinkStand");
        setSize(400,400);

        TextureRegion[][]temp=region.split(region.getRegionWidth()/2,region.getRegionHeight());
        frames=new TextureRegion[(temp.length*temp[0].length)];

        int index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                frames[index++]=temp[i][j];
            }
        }

        animacio =new Animation(0.15f,frames);


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        duracio += Gdx.graphics.getDeltaTime();
        anim= (TextureRegion) animacio.getKeyFrame(duracio,true);
        batch.draw(anim,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}