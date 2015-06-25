package com.nightblade.backend;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameView {
	private OrthographicCamera camera; //used to view the world
	private Viewport viewport; //viewport used to resize screen to a specified aspect ratio and makes sure image isn't stretched weirdly in different aspects
	
	public GameView (float GAME_WORLD_WIDTH, float GAME_WORLD_HEIGHT, float aspectRatio) {
		camera = new OrthographicCamera(); //instantiating camera
		viewport = new StretchViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);//instantiating viewport as a StretchViewport and making it have the correct width and height and passing the camera to manage
		viewport.apply(); //applying viewport
		camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_HEIGHT/2, 0); //positioning camera to middle of game world
	}
	
	/**
	 * @return the camera
	 */
	public OrthographicCamera getCamera() {
		return camera;
	}

	/**
	 * @return the viewport
	 */
	public Viewport getViewport() {
		return viewport;
	}
	
}
