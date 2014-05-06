package com.me.actor.button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.setup.Config;
import com.me.xpad.XPad;

public class ConfigModeButton extends TextButton{
    
    private SoundButton targetButton;
    private int target;
    private String buttonName;
    
    public ConfigModeButton(String name, int whatConfig) {
        super(name, Config.getButtonConfigStyle());
        
        target = whatConfig;
        buttonName = name;
        
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                if (target == Config.LOOP_CONFIG_BUTTON) {
                    if (targetButton.isLoop()) {
                        targetButton.setLoop(false);
                        // set dark button
                        setButtonStyle(Config.CONFIG_STYLE);
                        setName(buttonName + ": Off");
                    }
                    else {
                        targetButton.setLoop(true);
                        // set light button
                        setButtonStyle(Config.ICONFIG_STYLE);
                        setName(buttonName + ": On");
                    }
                        
                    XPad.configScreen.getConfigWindowButton(targetButton.getButtonIndex()).updateLoop();
                }
                else if (target == Config.HOLD_CONFIG_BUTTON) {
                    if (targetButton.isHold()) {
                        targetButton.setHold(false);
                        // set dark button
                        setButtonStyle(Config.CONFIG_STYLE);
                        setName(buttonName + ": Off");
                    }
                    else {
                        targetButton.setHold(true);
                        // set light button
                        setButtonStyle(Config.ICONFIG_STYLE);
                        setName(buttonName + ": On");
                    }
                        
                    XPad.configScreen.getConfigWindowButton(targetButton.getButtonIndex()).updateHold();
                }
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }
    
    public void setTargetButton(int indexButton) {
        targetButton = XPad.appScreen.getSoundButton(indexButton);
        
        if (((target == Config.LOOP_CONFIG_BUTTON) && (targetButton.isLoop()))
                || ((target == Config.HOLD_CONFIG_BUTTON) && (targetButton.isHold()))) {
            setButtonStyle(Config.ICONFIG_STYLE);
            setName(buttonName + ": On");
        }
        else {
            setButtonStyle(Config.CONFIG_STYLE);
            setName(buttonName + ": Off");
        }
    }
    
    public void setButtonStyle(int buttonStyle) {
        
        if (buttonStyle == Config.CONFIG_STYLE) {
            this.setStyle(Config.getButtonConfigStyle());
        }
        else if (buttonStyle == Config.ICONFIG_STYLE) {
            this.setStyle(Config.getButtonIConfigStyle());
        }
    } 
    
    public void setName(String newName) {
        this.setText(newName);
    }
    
}
