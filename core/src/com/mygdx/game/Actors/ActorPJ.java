package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPJ extends Actor {

    TextureAtlas atlas;
    TextureRegion region,regionup,regionright,regionleft,regionsp, regionattack,regionattackup,regionattackright,regionattackleft;
    TextureRegion[] frames,framesup,framesright,framesleft,framessp,framesattack,framesattackup,framesattackright,framesattackleft;
    Animation animacio,animacioup,animacioright,animacioleft,animaciosp,animacioattack,animacioattackup,animacioattackright,animacioattackleft;
    float duracio;
    TextureRegion anim;
    Animation[]anims;


    public static final int MAXARRAY = 9;

    public static final int PJ_STAND = 0;
    public static final int PJ_UP = 1;
    public static final int PJ_RIGHT = 2;
    public static final int PJ_LEFT=3;
    public static final int PJ_SP=4;
    public static final int PJ_ATTACK=5;
    public static final int PJ_ATTACKUP=6;
    public static final int PJ_ATTACKLEFT=7;
    public static final int PJ_ATTACKRIGHT=8;

    public static int direction;
    public static int life;

    public ActorPJ() {
        direction= PJ_STAND;
        life=3;


        //Crear sprite quan el pj esta quiet
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


        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionup=atlas.findRegion("LinkStandB");
        setSize(400,400);

        temp=regionup.split(regionup.getRegionWidth()/2,regionup.getRegionHeight());
        framesup=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesup[index++]=temp[i][j];
            }
        }




        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionleft=atlas.findRegion("LinkStandL");
        setSize(400,400);

        temp=regionleft.split(regionleft.getRegionWidth()/2,regionleft.getRegionHeight());
        framesleft=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesleft[index++]=temp[i][j];
            }
        }


        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionright=atlas.findRegion("LinkStandR");
        setSize(400,400);

        temp=regionright.split(regionright.getRegionWidth()/2,regionright.getRegionHeight());
        framesright=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesright[index++]=temp[i][j];
            }
        }


        //Crear sprite quan el pj utilitza l'attack especial
        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionsp=atlas.findRegion("LinkSP");
        setSize(400,400);

        temp=regionsp.split(regionsp.getRegionWidth()/13,regionsp.getRegionHeight());
        framessp=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framessp[index++]=temp[i][j];
            }
        }


        //Crear sprite quan el pj ataca
        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionattack=atlas.findRegion("LinkAttack");
        setSize(400,400);

        temp=regionattack.split(regionattack.getRegionWidth()/7,regionattack.getRegionHeight());
        framesattack=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesattack[index++]=temp[i][j];
            }
        }


        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionattackup=atlas.findRegion("LinkAttackB");
        setSize(400,400);

        temp=regionattackup.split(regionattackup.getRegionWidth()/7,regionattackup.getRegionHeight());
        framesattackup=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesattackup[index++]=temp[i][j];
            }
        }


        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionattackleft=atlas.findRegion("LinkAttackL");
        setSize(400,400);

        temp=regionattackleft.split(regionattackleft.getRegionWidth()/7,regionattackleft.getRegionHeight());
        framesattackleft=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesattackleft[index++]=temp[i][j];
            }
        }


        atlas=new TextureAtlas("fitxerAtlas.atlas");
        regionattackright=atlas.findRegion("LinkAttackR");
        setSize(400,400);

        temp=regionattackright.split(regionattackright.getRegionWidth()/7,regionattackright.getRegionHeight());
        framesattackright=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesattackright[index++]=temp[i][j];
            }
        }


        //crear la animació corresponent a cada acció
        animacio =new Animation(0.15f,frames);
        animacioup =new Animation(0.15f,framesup);
        animacioleft =new Animation(0.15f,framesleft);
        animacioright =new Animation(0.15f,framesright);
        animaciosp =new Animation(0.1f,framessp);
        animacioattack =new Animation(0.1f,framesattack);
        animacioattackup =new Animation(0.1f,framesattackup);
        animacioattackleft =new Animation(0.1f,framesattackleft);
        animacioattackright =new Animation(0.1f,framesattackright);



        //Guardar animacions al array d'animacions
        anims=new Animation[MAXARRAY];
        anims[0]=animacio;
        anims[1]=animacioup;
        anims[2]=animacioleft;
        anims[3]=animacioright;
        anims[4]=animaciosp;
        anims[5]=animacioattack;
        anims[6]=animacioattackup;
        anims[7]=animacioattackleft;
        anims[8]=animacioattackright;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(getPjAnim(),getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }

    public TextureRegion getPjAnim() {
        switch (direction) {
            case PJ_STAND:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[0].getKeyFrame(duracio,true);
                return anim;

            case PJ_UP:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[1].getKeyFrame(duracio,true);
                return anim;

            case PJ_LEFT:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[2].getKeyFrame(duracio,true);
                return anim;

            case PJ_RIGHT:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[3].getKeyFrame(duracio,true);
                return anim;

            case PJ_SP:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[4].getKeyFrame(duracio,true);
                return anim;

            case PJ_ATTACK:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[5].getKeyFrame(duracio,true);
                return anim;

            case PJ_ATTACKUP:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[6].getKeyFrame(duracio,true);
                return anim;

            case PJ_ATTACKLEFT:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[7].getKeyFrame(duracio,true);
                return anim;

            case PJ_ATTACKRIGHT:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[8].getKeyFrame(duracio,true);
                return anim;

            default:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[0].getKeyFrame(duracio,true);
                return anim;
        }

    }


    public void goDown() {
        direction=0;
    }

    public void goUp() { direction=1;}

    public void goRight(){
        direction=2;
    }

    public void goLeft() {
        direction=3;
    }

    public void goSP(){
        direction=4;
    }

    public void goAttack(){
        direction=5;
    }

    public void goAttackUp(){
        direction=6;
    }

    public void goAttackLeft(){
        direction=7;
    }

    public void goAttackRight(){
        direction=8;
    }

    public static int getDirection() {
        return direction;
    }


    public static int getLife() {
        return life;
    }

    public static void setLife(int life) {
        ActorPJ.life = life;
    }
}