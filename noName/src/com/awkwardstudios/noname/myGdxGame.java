package com.awkwardstudios.noname;



import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class myGdxGame implements Screen {

	OrthographicCamera camera;
	SpriteBatch batch;
	Texture dropImage;
	Texture bucketImage;
	Rectangle bucket;
	Sound dropSound;
	Music rainMusic;
	Vector3 touchPos;
	Array<Rectangle> raindrops;
	long lastDropTime;
	boolean loaded;
	Assets asset;
	//Assets2 asset;
	//AssetManager asset;
	noName game;
	
	public myGdxGame(noName g) {
		this.game = g;
		loaded = false;
		
		//asset = new AssetManager();

		//asset.load("data/droplet.png", Texture.class);
		//asset.load("data/bucket.png", Texture.class);
		//asset.load("data/drop.wav", Sound.class);
		//asset.load("data/rain.mp3", Music.class);
		
		//asset = new Assets("data/assets.xml");
		asset = new Assets("data/assets.json");
		asset.loadGroup("rain");

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();
		bucket = new Rectangle();
		 bucket.x = 480 / 2 - 64 / 2;
		 bucket.y = 20;
		 bucket.width = 64;
		 bucket.height = 64;
		 
		 raindrops = new Array<Rectangle>();
		 spawnRaindrop();
	      
		/*
		 
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		*/
	}

	@Override
	public void dispose() {
		dropImage.dispose();
	    bucketImage.dispose();
	    dropSound.dispose();
	    rainMusic.dispose();
	    batch.dispose();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if(loaded)
		{
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		 for(Rectangle raindrop: raindrops) {
			    batch.draw(dropImage, raindrop.x, raindrop.y);
			 }
		batch.end();
		
		 if(Gdx.input.isTouched()) {
			    touchPos = new Vector3();
			    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			    camera.unproject(touchPos);
			    bucket.x = touchPos.x - 64 / 2;
			 }
		 if(Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		 if(Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
		 if(bucket.x < 0) bucket.x = 0;
		 if(bucket.x > 480 - 64) bucket.x = 480 - 64;
		 if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
		 Iterator<Rectangle> iter = raindrops.iterator();
		 while(iter.hasNext()) {
		    Rectangle raindrop = iter.next();
		    raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
		    if(raindrop.y + 64 < 0) iter.remove();

			 if(raindrop.overlaps(bucket)) {
			       dropSound.play();
			       iter.remove();
			    }
		 }
		}
		else
		{
			loaded = asset.update();
			if(loaded)
			{
		      
		      dropImage = asset.get("data/droplet.png", Texture.class);
				bucketImage = asset.get("data/bucket.png", Texture.class);
				dropSound = asset.get("data/drop.wav", Sound.class);
				rainMusic = asset.get("data/rain.mp3", Music.class);
		      // start the playback of the background music immediately
		      rainMusic.setLooping(true);
		      rainMusic.play();
		}
		}
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
	
	private void spawnRaindrop() {
	    Rectangle raindrop = new Rectangle();
	    raindrop.x = MathUtils.random(0, 480-64);
	    raindrop.y = 800;
	    raindrop.width = 64;
	    raindrop.height = 64;
	    raindrops.add(raindrop);
	    lastDropTime = TimeUtils.nanoTime();
	 }

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
