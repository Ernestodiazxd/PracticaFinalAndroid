package com.mygdx.game.Inputs;

import com.badlogic.gdx.InputAdapter;
import com.mygdx.game.GhostKiller;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.TutorialScreen;

//Classe que s'encarrega de cambiar les pantalles
public class Entrada extends InputAdapter {
    //Inicialitzem les variables
    GhostKiller joc;
    GameScreen g;
    TutorialScreen t;


    //constructor per agafar les variables de Joc
    public Entrada(GhostKiller joc) {
        this.joc = joc;
        this.t=new TutorialScreen(joc);
    }

    //Quan apretem la pantalla, cambia d'una a un altre
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        joc.setScreen(t);
        return true;
    }

}
