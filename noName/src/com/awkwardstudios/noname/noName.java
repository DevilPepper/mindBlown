package com.awkwardstudios.noname;

import com.badlogic.gdx.ApplicationListener;

public class noName implements ApplicationListener {
        // give noName some properties
        
        @Override
        public void create() {                
                // initialize the properties here
        }


        @Override
        public void dispose() {
                //delete stuff here
        }

        @Override
        public void render() {                
                //every frame
        	/*
        	if(Gdx.input.isTouched())
        	{
        	stuff.printf("hbdkdbd\n");
        	stuff.printf(Gdx.input.getX()+"\n");
        	stuff.printf("(x,y): (%d, %d)\n", Gdx.input.getX(), Gdx.input.getY());
        	}
        	*/
        }

        @Override
        public void resize(int width, int height) {
        }

        @Override
        public void pause() {
        }

        @Override
        public void resume() {
        }

}