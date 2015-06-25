package com.nightblade.backend;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class PlayerInput extends InputAdapter {

	private boolean keyUp = false;
	private boolean keyDown = false;
	private boolean keyLeft = false;
	private boolean keyRight = false;

	
	@Override
	public boolean keyDown(int keycode){
		if (keycode == Keys.UP){
			keyUp = true;
		}
		if (keycode == Keys.DOWN){
			keyDown = true;
		}
		if (keycode == Keys.LEFT){
			keyLeft = true;
		}
		if (keycode == Keys.RIGHT){
			keyRight = true;
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode){
		if (keycode == Keys.UP){
			keyUp = false;
		}
		if (keycode == Keys.DOWN){
			keyDown = false;
		}
		if (keycode == Keys.LEFT){
			keyLeft = false;
		}
		if (keycode == Keys.RIGHT){
			keyRight = false;
		}
		return true;
	}
	
	/**
	 * @return the keyUp
	 */
	public boolean isKeyUp() {
		return keyUp;
	}

	/**
	 * @return the keyDown
	 */
	public boolean isKeyDown() {
		return keyDown;
	}

	/**
	 * @return the keyLeft
	 */
	public boolean isKeyLeft() {
		return keyLeft;
	}

	/**
	 * @return the keyRight
	 */
	public boolean isKeyRight() {
		return keyRight;
	}
}