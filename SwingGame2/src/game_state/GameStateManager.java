package game_state;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GameStateManager {
	
	public static final int NUM_GAME_STATES = 3;
	private GameState[] gameStates;
	private int currentState;
	
	public static final int STATE_MENU = 0;
	public static final int STATE_LV_1 = 1;
	public static final int STATE_LV_0 = 2;
	
	public GameStateManager() {
		
		gameStates = new GameState[NUM_GAME_STATES];
		
		currentState = STATE_MENU;
		loadState(currentState);
	}
	
	private void loadState(int state) {
		if(state == STATE_MENU)
			gameStates[state] = new MenuState(this);
		if(state == STATE_LV_1)
			gameStates[state] = new Level1State(this);
		if(state == STATE_LV_0)
			gameStates[state] = new Level2State(this);
	}
	
	private void unloadState(int state){
		gameStates[state] = null;
	}
	
	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
		currentState = state;
		
		// gameStates[currentState].init();
	}
	
	public void update() {
		try{
			gameStates[currentState].update();
			// System.out.println(gameStates[currentState]);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g){
		try {
			gameStates[currentState].draw(g);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	
	public void keyPressed(int k){
		gameStates[currentState].keyPressed(k);
	}
	
	public void keyReleased(int k){
		gameStates[currentState].keyReleased(k);
	}
}
