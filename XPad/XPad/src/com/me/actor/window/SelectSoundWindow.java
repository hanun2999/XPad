package com.me.actor.window;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Array;
import com.me.setup.Config;

public class SelectSoundWindow extends Window{
    
    private static float h = Gdx.graphics.getHeight();
    private static float w = Gdx.graphics.getWidth();
    
    private Label openFile = new Label("  Open file...", Config.getLabelStyle());
    private SelectBox<String> soundLibrary = new SelectBox<String>(Config.getSoundSelectStyle());
    
    private Array<String> listSound = new Array<String>();
    
    public SelectSoundWindow() {
        super("", Config.getConfigWindowStyle());
        
        this.setSize(2 * h / 5, 2 * h / 10);
        this.setPosition(w / 2 + h / 5 + 5, h / 2 + h / 10);
        this.setMovable(false);
        
        openFile.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        
        soundLibrary.setItems("Chosen...", "Default", "1", "2", "3", "4", "5", "6");
        soundLibrary.setSelected("Chosen...");
        
        this.add(openFile).size(2 * h / 5, h / 10);
        this.row();
        this.add(soundLibrary).size(2 * h / 5 - 20, h / 10);
    }
    
    
}
