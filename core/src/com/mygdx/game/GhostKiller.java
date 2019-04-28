package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Inputs.Entrada;
import com.mygdx.game.Screens.MenuScreen;

public class GhostKiller extends Game {
	SpriteBatch batch;
	public int altura,amplada;
	Entrada entrada;


	public SpriteBatch getBatch() {
		return batch;
	}

	public int getAltura() {
		return altura;
	}

	public int getAmplada() {
		return amplada;
	}


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

	@Override
	public void dispose () {
		batch.dispose();

	}
}
