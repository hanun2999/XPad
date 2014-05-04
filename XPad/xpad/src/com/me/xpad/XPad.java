package com.me.xpad;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.me.screen.AppScreen;
import com.me.screen.ConfigScreen;
import com.me.setup.Config;
import com.me.setup.Sound;

public class XPad extends Game implements ApplicationListener{
    
    public static AppScreen appScreen;
    public ConfigScreen configScreen;
    
    @Override
    public void create() {        
    	Sound.setSound(Config.SLOT_0, "C4", Gdx.files.internal("sounds/C4.mp3"));
        Sound.setSound(Config.SLOT_1, "D4", Gdx.files.internal("sounds/D4.mp3"));
        Sound.setSound(Config.SLOT_2, "E4", Gdx.files.internal("sounds/E4.mp3"));
        Sound.setSound(Config.SLOT_3, "F4", Gdx.files.internal("sounds/F4.mp3"));
        Sound.setSound(Config.SLOT_4, "G4", Gdx.files.internal("sounds/G4.mp3"));
        Sound.setSound(Config.SLOT_5, "A4", Gdx.files.internal("sounds/A4.mp3"));
        Sound.setSound(Config.SLOT_6, "B4", Gdx.files.internal("sounds/B4.mp3"));
        Sound.setSound(Config.SLOT_7, "C5", Gdx.files.internal("sounds/C5.mp3"));
        Sound.setSound(Config.SLOT_8, "D5", Gdx.files.internal("sounds/D5.mp3"));
        Sound.setSound(Config.SLOT_9, "E5", Gdx.files.internal("sounds/E5.mp3"));
        Sound.setSound(Config.SLOT_10, "F5", Gdx.files.internal("sounds/F5.mp3"));
        Sound.setSound(Config.SLOT_11, "G5", Gdx.files.internal("sounds/G5.mp3"));
        Sound.setSound(Config.SLOT_12, "A5", Gdx.files.internal("sounds/A5.mp3"));
        Sound.setSound(Config.SLOT_13, "B5", Gdx.files.internal("sounds/B5.mp3"));
        Sound.setSound(Config.SLOT_14, "C6", Gdx.files.internal("sounds/C6.mp3"));
        Sound.setSound(Config.SLOT_15, "TheWayIAre", Gdx.files.internal("sounds/TheWayIAre.mp3"));
        appScreen = new AppScreen(this);
        configScreen = new ConfigScreen(this);        
    }

    @Override
    public void dispose() {
        Config.dispose();
}

    @Override
    public void render() {   
    	super.render();
    }

    @Override
    public void resize(int width, int height) {
    	super.resize(width, height);
    	setScreen(appScreen);
    }

    @Override
    public void pause() {
    	super.pause();
    }

    @Override
    public void resume() {
    	super.resume(); 
    }
    
    @Override
    public void setScreen(Screen screen) {
    	super.setScreen(screen);
    }
}