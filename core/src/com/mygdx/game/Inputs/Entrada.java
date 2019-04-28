package com.mygdx.game.Inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.Screens.GameScreen;

public class Entrada extends InputAdapter {
    GhostKiller joc;
    GameScreen g;
    Music music;


    public Entrada(GhostKiller joc) {
        this.joc = joc;
        this.g=new GameScreen(joc);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        joc.setScreen(g);
        return true;
    }

}
