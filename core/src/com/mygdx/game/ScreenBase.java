package com.mygdx.game;

import com.badlogic.gdx.Screen;

public abstract class ScreenBase implements Screen {

    protected Game joc;

    public ScreenBase(Game joc) {
        this.joc = joc;
    }
}
