package com.me.actor.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.me.setup.Config;
import com.me.xpad.XPad;

public class ShowConfigWindowButton extends Table{

    private static float h = Gdx.graphics.getHeight();
    
    private SoundButton showLoop = new SoundButton();
    private SoundButton showHold = new SoundButton();
    
    private int buttonIndex;
    
    public ShowConfigWindowButton(int index) {
        
        super();
        
        buttonIndex = index;
        
        this.setBackground(Config.getButtonSkin().getDrawable("BtnDark"));
        
        showLoop.setText("Loop");
        updateLoop();
        
        showHold.setText("Hold");
        updateHold();
         
        
        this.add(showLoop).size(h / 4, h / 8);
        this.row();
        this.add(showHold).size(h / 4, h / 8);
        
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                XPad.configScreen.getMainGroup().setTouchable(Touchable.disabled);
                XPad.configScreen.getBlurImage().setVisible(true);
                XPad.configScreen.getSettingWindow().showSettingWindow(buttonIndex);
                
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }
    
    public void updateLoop() {
        
        if (XPad.appScreen.getSoundButton(buttonIndex).isLoop()) {
            showLoop.setStyle(Config.getButtonIModeStyle());
        }
        else {
            // loop sound style equal inverte default style
            showLoop.setStyle(Config.getButtonModeStyle());
        }
    }
    
    public void updateHold() {
        
        if (XPad.appScreen.getSoundButton(buttonIndex).isHold()) {
            showHold.setStyle(Config.getButtonIModeStyle());
        }
        else {
            // loop sound style equal inverte default style
            showHold.setStyle(Config.getButtonModeStyle());
        }
    }
}
