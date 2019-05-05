package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Inputs.Entrada;
import com.mygdx.game.Screens.MenuScreen;


//Clase inicial del Game
public class GhostKiller extends Game {
	//inicialitzem les variables
	SpriteBatch batch;
	public int altura,amplada;
	Entrada entrada;


	//getters i setters
	public SpriteBatch getBatch() {
		return batch;
	}

	public int getAltura() {
		return altura;
	}

	public int getAmplada() {
		return amplada;
	}


	//Emplenar les variables
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MenuScreen(this));

		altura = Gdx.graphics.getHeight();
		amplada = Gdx.graphics.getWidth();

		entrada=new Entrada(this);
		Gdx.input.setInputProcessor(entrada);

	}

	@Override
	public void render() {
		super.render();
	}

	//netejar la memoria
	@Override
	public void dispose () {
		batch.dispose();

	}
}
