package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Entrada extends InputAdapter {
    Game joc;
    GameScreen g;


    public Entrada(Game joc) {
        this.joc = joc;
        this.g=new GameScreen(joc);

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        joc.setScreen(g);
        return true;
    }
}
