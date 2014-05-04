package com.me.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.me.setup.Config;

/**
 * <code>
 *  <p>Package name: com.me.actor
 *  <p>Class name: MyTable
 *  <p>Description: This class is own Table extends from LibGdx's Table
 *  <p>{@link Table}
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class MyTable extends Table {
	
    private static final float w = Gdx.graphics.getWidth();
    private static final float h = Gdx.graphics.getHeight();
    
    /**
     * <code>
     *     <p>Define a new table
     * </code>
     * @author Ho Hai Vu
     */
	public MyTable(int tableType) {
		super();
		//this.setPosition((Gdx.graphics.getWidth()-Gdx.graphics.getHeight())/2, 0);
		if (tableType == Config.SOUND_TABLE) {
    		this.setPosition(w - 5 * h / 4, 0);
    		this.setWidth(5 * h / 4);
    		this.setHeight(h);
		}
		else if (tableType == Config.FUNC_TABLE) {
		    this.setPosition(0, 0);
            this.setWidth(3 * h / 8);
            this.setHeight(h);
		}
	}
	
	/**
     * <code>
     *     <p>Method to add button to table
     * </code>
     * @author Ho Hai Vu
     */
	public void addSoundButton(Actor actor) {
		super.add(actor).size(h/4, h/4);
	}	
	
	public void addFuncButton(Actor actor) {
        super.add(actor).size(3*h/16, h/4);
    }   
}
