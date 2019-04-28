package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;

public class Entrada extends InputAdapter {
    Game joc;
    GameScreen g;
    Music music;


    public Entrada(Game joc) {
        this.joc = joc;
        this.g=new GameScreen(joc);
        this.music = Gdx.audio.newMusic(Gdx.files.internal("data/start.mp3"));

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        music.play();
        joc.setScreen(g);
        return true;
    }
}
