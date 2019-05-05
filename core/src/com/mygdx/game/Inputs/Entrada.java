package com.mygdx.game.Inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.TutorialScreen;

public class Entrada extends InputAdapter {
    GhostKiller joc;
    GameScreen g;
    TutorialScreen t;


    public Entrada(GhostKiller joc) {
        this.joc = joc;
        this.g=new GameScreen(joc);
        this.t=new TutorialScreen(joc);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        joc.setScreen(t);
        return true;
    }

}
