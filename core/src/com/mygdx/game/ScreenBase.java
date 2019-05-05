package com.mygdx.game;

import com.badlogic.gdx.Screen;

//Classe que ens serveix com a base per crear les diferents Screens del joc
public abstract class ScreenBase implements Screen {

    protected GhostKiller joc;

    public ScreenBase(GhostKiller joc) {
        this.joc = joc;
    }
}
