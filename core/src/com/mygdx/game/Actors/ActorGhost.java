package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.scenes.scene2d.Actor;


//Actor dels enemics
public class ActorGhost extends Actor {

    //inicialitzar variables
    TextureAtlas atlas;
    TextureRegion ghostRed,ghostOrange,ghostBlue,ghostPink;
    TextureRegion[] framesRed,framesOrange,framesBlue,framesPink;
    Animation animacioRed,animacioOrange,animacioBlue,animacioPink;
    float duracio;
    TextureRegion anim;
    Animation[]anims;
    private int x,y;



    public static final int MAXARRAY = 4;

    public static final int RED = 0;
    public static final int ORANGE = 1;
    public static final int BLUE = 2;
    public static final int PINK=3;

    public static int color;

    //rectangle de colisions
    Rectangle colision;

    //Constructor emplenar les variables
    public ActorGhost() {


        //Crear els diferents sprites
        atlas=new TextureAtlas("fitxerAtlas.atlas");
        ghostRed=atlas.findRegion("red/RedU");
        setSize(70,70);

        TextureRegion[][]temp=ghostRed.split(ghostRed.getRegionWidth()/2,ghostRed.getRegionHeight());
        framesRed=new TextureRegion[(temp.length*temp[0].length)];

        int index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesRed[index++]=temp[i][j];
            }
        }

        atlas=new TextureAtlas("fitxerAtlas.atlas");
        ghostOrange=atlas.findRegion("orange/OrangeU");
        setSize(70,70);

        temp=ghostOrange.split(ghostOrange.getRegionWidth()/2,ghostOrange.getRegionHeight());
        framesOrange=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesOrange[index++]=temp[i][j];
            }
        }


        atlas=new TextureAtlas("fitxerAtlas.atlas");
        ghostBlue=atlas.findRegion("blue/BlueU");
        setSize(70,70);

        temp=ghostBlue.split(ghostBlue.getRegionWidth()/2,ghostBlue.getRegionHeight());
        framesBlue=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesBlue[index++]=temp[i][j];
            }
        }

        atlas=new TextureAtlas("fitxerAtlas.atlas");
        ghostPink=atlas.findRegion("pink/PinkU");
        setSize(70,70);

        temp=ghostPink.split(ghostPink.getRegionWidth()/2,ghostPink.getRegionHeight());
        framesPink=new TextureRegion[(temp.length*temp[0].length)];

        index=0;
        for (int i=0; i<temp.length;i++){
            for (int j=0; j< temp[0].length;j++){
                framesPink[index++]=temp[i][j];
            }
        }



        //incloure animacions
        animacioRed =new Animation(0.15f,framesRed);
        animacioOrange =new Animation(0.15f,framesOrange);
        animacioBlue =new Animation(0.15f,framesBlue);
        animacioPink =new Animation(0.15f,framesPink);


        //emplenar array d'animacions
        anims=new Animation[MAXARRAY];

        anims[0]=animacioRed;
        anims[1]=animacioOrange;
        anims[2]=animacioBlue;
        anims[3]=animacioPink;



        colision = new Rectangle(x,y,90,90);

    }

    //dibuixar
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(getGhostAnim(),getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());

    }

    //actualizar coordenades per controlar les colisions
    public void pasarCoordenades(int x, int y){
        this.x=x;
        this.y=y;
        colision.setPosition(x,y);
    }

    //mesures del rectangle de colisions
    public Rectangle getBounds(){
        return colision;
    }


    //switch per cambiar l'animació
    public TextureRegion getGhostAnim() {
        switch (color) {
            case RED:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[0].getKeyFrame(duracio,true);
                return anim;

            case ORANGE:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[1].getKeyFrame(duracio,true);
                return anim;

            case BLUE:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[2].getKeyFrame(duracio,true);
                return anim;

            case PINK:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[3].getKeyFrame(duracio,true);
                return anim;

            default:
                duracio += Gdx.graphics.getDeltaTime();
                anim= (TextureRegion) anims[0].getKeyFrame(duracio,true);
                return anim;
        }

    }



}
