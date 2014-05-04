package com.me.actor;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * <code>
 *  <p>Package name: com.me.actor
 *  <p>Class name: MyStage
 *  <p>Description: This object is own Stage extend from LibGdx's Stage
 *  <p>{@link Stage}
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class MyStage extends Stage{
	private OrthographicCamera camera;
	private Viewport view;
	
	/**
     * <code>
     *     <p>Define a new stage
     * </code>
     * @author Ho Hai Vu
     */
	public MyStage(float width, float height, boolean yDown){
		
	    // Create a camera
		camera = new OrthographicCamera();
		camera.setToOrtho(yDown, width, height);
		
		// Create a viewport with camera
		view = new ScreenViewport(camera);
		view.setWorldHeight(height);
		view.setWorldWidth(width);
		
		super.setViewport(view);
		super.clear();
	}
	
	/**
     * <code>
     *     <p>Set a stage background
     * </code>
     * @author Ho Hai Vu
     */
	public void setBackground(FileHandle backgroundFile) {
	    
		Texture texture = new Texture(backgroundFile);
		
		Image image = new Image(texture);
		image.setWidth(this.getWidth());
		image.setHeight(this.getHeight());
		super.addActor(image);
	}
	
	/**
     * <code>
     *     <p>Dispose stage
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void dispose() {
		super.dispose();
	}
}
