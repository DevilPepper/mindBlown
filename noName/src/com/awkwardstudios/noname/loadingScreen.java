package com.awkwardstudios.noname;



public class loadingScreen extends basicScreen {
	 

    basicScreen screen;


    public void load(basicScreen s, String groupName)
    {

        screen.game.asset.loadGroup(groupName);
    }
    // constructor to keep a reference to the main Game class
     public loadingScreen(noName g){
    	super(g);
    	this.screen = game.rain;
     }
     
     @Override
     public void render(float delta) {
    	 if(screen.game.asset.update())screen.game.setScreen(screen);
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