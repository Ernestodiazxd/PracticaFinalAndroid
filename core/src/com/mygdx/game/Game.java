package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Game extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	int altura,amplada;
	TextureAtlas atlas;
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

	public TextureAtlas getAtlas() {
		return atlas;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		atlas=new TextureAtlas("fitxerAtlas.atlas");
		altura = Gdx.graphics.getHeight();
		amplada=Gdx.graphics.getWidth();



		MenuScreen s = new MenuScreen(this);
		setScreen(s);
		entrada=new Entrada(this);
		Gdx.input.setInputProcessor(entrada);



	}

	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
