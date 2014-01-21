package com.awkwardstudios.noname;

import com.badlogic.gdx.Game;

public class noName extends Game {
	splashScreen splash;
	titleScreen tit;
	optionsScreen options;
	gameOverScreen gameOver;
	stage1Screen stage1;
	endlessScreen endless;
	creditsScreen credits;
	rainNbucket rain;
	
	loadingScreen load;
	public Assets asset;

   @Override
    public void create() {
	   asset = new Assets("data/assets.xml");

	   rain = new rainNbucket(this);
	   splash = new splashScreen(this); //load loading screen assets while displaying this
	   load = new loadingScreen(this);
	   //tit = new titleScreen(this);
	   //options = new optionsScreen(this);
	   //gameOver = new gameOverScreen(this);
	   //stage1 = new stage1Screen(this);
	   //endless = new endlessScreen(this);
	   //credits = new creditsScreen(this);
	   
	   load.load(rain, "rain");
	   setScreen(load);
    }
}