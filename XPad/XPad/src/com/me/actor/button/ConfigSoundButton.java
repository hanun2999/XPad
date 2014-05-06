package com.me.actor.button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.setup.Config;
import com.me.xpad.XPad;

public class ConfigSoundButton extends TextButton{
    
    public ConfigSoundButton() {
        super(null, Config.getButtonSoundConfigStyle());
        
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (XPad.configScreen.getSelectSoundWindow().isVisible()) {
                    
                    XPad.configScreen.getSelectSoundWindow().setVisible(false);
                    XPad.configScreen.getBlurImage().setTouchable(Touchable.enabled);
                    XPad.configScreen.getSettingWindow().getLoopConfig().setTouchable(Touchable.enabled);
                    XPad.configScreen.getSettingWindow().getHoldConfig().setTouchable(Touchable.enabled);
                }
                else {
                    
                    XPad.configScreen.getSelectSoundWindow().setVisible(true);
                    XPad.configScreen.getBlurImage().setTouchable(Touchable.disabled);
                    XPad.configScreen.getSettingWindow().getLoopConfig().setTouchable(Touchable.disabled);
                    XPad.configScreen.getSettingWindow().getHoldConfig().setTouchable(Touchable.disabled);
                }
                
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }
}
