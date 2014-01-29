package com.awkwardstudios.noname;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;

public class noName extends Game {
	splashScreen splash;
	titleScreen tit;
	optionsScreen options;
	gameOverScreen gameOver;
	stage1Screen stage1;
	endlessScreen endless;
	creditsScreen credits;
	
	rainNbucket rain;
	testScroll scroll;
	
	loadingScreen load;
	Assets asset;
	
   @Override
    public void create() {
	   stuff.printf("nothing to see\n");

       Texture.setEnforcePotImages(false);
	   asset = new Assets("data/assets.xml");
	   rain = new rainNbucket(this);
	   scroll = new testScroll(this);
	   //splash = new splashScreen(this); //load loading screen assets while displaying this
	   load = new loadingScreen(this);
	   //tit = new titleScreen(this);
	   //options = new optionsScreen(this);
	   //gameOver = new gameOverScreen(this);
	   //stage1 = new stage1Screen(this);
	   //endless = new endlessScreen(this);
	   //credits = new creditsScreen(this);
	   stuff.printf("about to load\n");
	   load.load(scroll); //here
	   //stuff.printf("load was queued");
	   //setScreen(scroll); //causes error
    }
}