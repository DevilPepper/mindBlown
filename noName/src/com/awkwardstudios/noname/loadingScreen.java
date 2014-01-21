package com.awkwardstudios.noname;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Logger;



public class loadingScreen extends basicScreen {
	 

    basicScreen screen;
    Logger logger;

    public void load(basicScreen s, String groupName)
    {
        screen.game.asset.loadGroup(groupName);
    	logger.info("READY...");
    	//screen.game.asset.load("data/bucket.png", Texture.class);
    	//screen.game.asset.load("data/drop.wav", Sound.class);
    	//screen.game.asset.load("data/drop.wav", Sound.class);
    	//screen.game.asset.load("data/rain.mp3", Music.class);
        logger.info("do queuing");
    }
    // constructor to keep a reference to the main Game class
     public loadingScreen(noName g){
    	super(g);
    	this.screen = game.rain;
    	logger = new Logger("loading", Logger.INFO);
     }
     
     @Override
     public void render(float delta) {
    	 logger.info("RENDERING");
    	 if(screen.game.asset.update())screen.game.setScreen(screen);
    	 
    	 logger.info(Float.toString(screen.game.asset.getProgress()));
     }


    @Override
     public void resize(int width, int height) {
     }


    @Override
     public void show() {
          // called when this screen is set as the screen with game.setScreen();
     }


    @Override
     public void hide() {
          // called when current screen changes from this to a different screen
    	this.screen = game.rain;
     }


    @Override
     public void pause() {
     }


    @Override
     public void resume() {
     }


    @Override
     public void dispose() {
             // never called automatically
     }
}