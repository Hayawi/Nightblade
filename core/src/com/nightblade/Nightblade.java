package com.nightblade;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nightblade.backend.GameView;
import com.nightblade.backend.PlayerInput;

public class Nightblade extends Game {
	PlayerInput pInput;
	SpriteBatch batch;
	Sprite img;
	
	float aspectRatio; //The aspect ratio of the screen (eg. 4:3, 16:9, etc.)
	final float GAME_WORLD_WIDTH = 100; //The relative game width size (ie. in percentage rather than pixels)
	final float GAME_WORLD_HEIGHT = 100; //The relative game height size (ie. in percentage rather than pixels)
	
	GameView gameview; //using GameView as a seperate class in order to make sure the main NightBlade class is nice and neat
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		img.setPosition(0, 0);
		img.setSize(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT);
		
		aspectRatio = (float) Gdx.graphics.getHeight()/(float) Gdx.graphics.getWidth(); //Getting the aspect ratio
		
		gameview = new GameView(GAME_WORLD_WIDTH, GAME_WORLD_HEIGHT, aspectRatio); //instantiating GameView also instantiates camera and viewport
		
		pInput = new PlayerInput();
		Gdx.input.setInputProcessor(pInput);
	}

	@Override
	public void resize(int width, int height){
		gameview.getViewport().update(width, height); //in case there is a change in resolution
	}
	
	public void update (){
		if (pInput.isKeyUp()){
			gameview.getCamera().translate(0, 1f);
		}
		if (pInput.isKeyDown()){
			gameview.getCamera().translate(0, -1f);
		}
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gameview.getCamera().update();
		batch.setProjectionMatrix(gameview.getCamera().combined);
				
		batch.begin();
		img.draw(batch);
		batch.end();
		update();
	}
	
	@Override
	public void dispose(){
		img.getTexture().dispose();
	}
}
