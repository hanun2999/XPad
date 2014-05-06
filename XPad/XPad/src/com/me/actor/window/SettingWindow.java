package com.me.actor.window;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.me.actor.button.ConfigModeButton;
import com.me.actor.button.ConfigSoundButton;
import com.me.setup.Config;

public class SettingWindow extends Window{
    
    private static float h = Gdx.graphics.getHeight();
    private static float w = Gdx.graphics.getWidth();
    
    private ConfigModeButton loopConfig;
    private ConfigModeButton holdConfig;
    private ConfigSoundButton soundConfig;
    
    public SettingWindow() {
        super("", Config.getConfigWindowStyle());
        
        this.setSize(2 * h / 5, 3 * h / 5);
        this.setPosition(w / 2 - h / 5, h / 2 - 3 * h/10);
        this.setMovable(false);
        
        loopConfig = new ConfigModeButton("Loop", Config.LOOP_CONFIG_BUTTON);
        holdConfig = new ConfigModeButton("Hold", Config.HOLD_CONFIG_BUTTON);
        soundConfig = new ConfigSoundButton();
        
        this.add(soundConfig).size(2 * h / 5, h/5);
        this.row();
        this.add(loopConfig).size(2 * h / 5, h/5);
        this.row();
        this.add(holdConfig).size(2 * h / 5, h/5);
        this.row();
    }
    
    public void showSettingWindow(int indexButton) {
        loopConfig.setTargetButton(indexButton);
        holdConfig.setTargetButton(indexButton);
        this.setVisible(true);
    }
    
    public ConfigModeButton getLoopConfig() {
        return loopConfig;
    }
    
    public ConfigModeButton getHoldConfig() {
        return holdConfig;
    }
}
