package com.me.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.me.actor.MyStage;
import com.me.xpad.XPad;

/**
 * <code>
 *  <p>Package name: com.me.screen
 *  <p>Class name: ConfigScreen
 *  <p>Description: Config screen of application
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class ConfigScreen implements Screen{

	private MyStage stage;
	
	public ConfigScreen(final XPad xPad) {
		float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();                  
    
        stage = new MyStage(w, h, false);
        stage.clear();      
        stage.setBackground(Gdx.files.internal("wallpaper/wallpaper.png"));
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, false);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
