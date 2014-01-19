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

   @Override
    public void create() {
	   splash = new splashScreen(this);
	   tit = new titleScreen(this);
	   options = new optionsScreen(this);
	   gameOver = new gameOverScreen(this);
	   stage1 = new stage1Screen(this);
	   endless = new endlessScreen(this);
	   credits = new creditsScreen(this);
	   
	   setScreen(splash);
    }
}