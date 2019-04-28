package com.mygdx.game;

import com.badlogic.gdx.Screen;

public abstract class ScreenBase implements Screen {

    protected GhostKiller joc;

    public ScreenBase(GhostKiller joc) {
        this.joc = joc;
    }
}
