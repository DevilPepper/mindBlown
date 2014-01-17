package com.awkwardstudios.noname;

import com.badlogic.gdx.Game;

public class noName extends Game {

	splashScreen splash;
	titleScreen tit;

   @Override
    public void create() {
            
	   splash = new splashScreen(this);
	   tit = new titleScreen(this);
	   setScreen(splash);
    }
}