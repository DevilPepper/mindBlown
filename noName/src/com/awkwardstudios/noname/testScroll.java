package com.awkwardstudios.noname;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

public class testScroll extends basicScreen {
	 SpriteBatch spriteBatch;
	 Texture spriteTexture, topT, midT;
	 Sprite sprite;
	 Sprite mid;
	 Sprite top;

		Logger logger;
	 float scrollTimer = 0.0f;
	 
	 public testScroll(noName g){
		 super(g);
		 groupname = "scroll";
		 logger = new Logger("Scroll", Logger.INFO);
		 logger.info("init");
	     spriteBatch = new SpriteBatch();

	     logger.info("init done");
	 }
	 
	@Override
	 public void render(float delta) {

   	 logger.info("Guess who's rendering");
        // update and draw stuff
   	 Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		

	     scrollTimer+=Gdx.graphics.getDeltaTime()*-1;
	     if(scrollTimer>1.0f)
	         scrollTimer = 0.0f;
	     /*
	     if(spriteTexture.getWidth()>spriteTexture.getHeight())
	     {
	    	 sprite.setU(scrollTimer);//
	    	 sprite.setU2(scrollTimer+1);
	     }
	     else
	     {
	    	 sprite.setV(scrollTimer);//
	    	 sprite.setV2(scrollTimer+1);
	     }
	     */
    	 sprite.setV(scrollTimer);
    	 sprite.setV2(scrollTimer+1);
    	 top.setV(scrollTimer/3);
    	 top.setV2(scrollTimer/3 + 1);
	     mid.setRotation(scrollTimer/2);
	     spriteBatch.begin();
	     sprite.draw(spriteBatch);
	     mid.draw(spriteBatch);
	     top.draw(spriteBatch);
	     spriteBatch.end();
	 }
	
	 @Override
     public void show() {
		 logger.info("getting Texture");

	        //Texture.setEnforcePotImages(false);
		 spriteTexture = game.asset.get("data/bg_under.png", Texture.class);
	     logger.info("got texture");            
	     spriteTexture.setWrap(TextureWrap.Repeat,TextureWrap.Repeat);
	     sprite = new Sprite(spriteTexture, 0, 0, 480, 800);
	     sprite.setSize(480, 800);
	     
	     topT = game.asset.get("data/bg_over.png", Texture.class);
	     topT.setWrap(TextureWrap.Repeat,TextureWrap.Repeat);
	     top = new Sprite(topT, 0 , 0, 480, 800);
	     top.setSize(480, 800);
	     
	     midT = game.asset.get("data/bg_middle2.png", Texture.class);
	     mid = new Sprite(midT, 0 , 0, 480, 359);
	     mid.setSize(480, 359);
	     mid.setPosition(0, 220);
	     
	 }

}
