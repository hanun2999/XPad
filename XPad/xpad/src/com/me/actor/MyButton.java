package com.me.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.screen.AppScreen;
import com.me.setup.Config;
import com.me.setup.Sound;
import com.me.time.Moment;
import com.me.xpad.XPad;

/**
 * <code>
 *  <p>Package name: com.me.actor
 *  <p>Class name: MyButton
 *  <p>Description: This class is own button extends from LibGdx's TextButton
 *  <p>{@link TextButton} 
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class MyButton extends TextButton{
	
    private int loopASlotIndex;
    private int index;
    
    private boolean holdButton;
    private boolean loopSound;
    private boolean looping;
    
    /**
     * <code>
     *     <p>Define a new button with style and input event
     * </code>
     * @author Ho Hai Vu
     */
	public MyButton(final int soundSlotNumber) {
        super(null, Config.getButtonDefaultStyle());
        
        index = soundSlotNumber;
        
		this.addListener(new InputListener() {
        	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        	    
        	    XPad.appScreen.setting.setVisible(true);
        	    
        	    if (XPad.appScreen.anyButtonIsLoop()) {
        	        
        	        loopASlotIndex = XPad.appScreen.getButtonIsLoop().getLoop().getIndex();
        	        
        	        XPad.appScreen.getButtonIsLoop().getLoop().createNewSlot(soundSlotNumber);
        	        
        	        XPad.appScreen.getButtonIsLoop().getLoop().getSlot(loopASlotIndex)
        	        .setTouchDownMoment(new Moment(XPad.appScreen.getButtonIsLoop().getLoop().getStartMoment()));
        	    }
        	    
        		Sound.stopSound(soundSlotNumber);
        		
        		if (loopSound && !looping) {
        		    looping = true;
        		    Sound.loopSound(soundSlotNumber);
        		    XPad.appScreen.getSoundButton(soundSlotNumber).setButtonStyle(Config.LOOP_SOUND_STYLE);
        		}
        		else if (loopSound && looping) {
        		    looping = false;
                    XPad.appScreen.getSoundButton(soundSlotNumber).setButtonStyle(Config.DEFAULT_STYLE);
        		}
        		else
        		    Sound.playSound(soundSlotNumber);
        		
            	return true;
			}
        	
        	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        		if (XPad.appScreen.anyButtonIsLoop()) {
        		    
        		    XPad.appScreen.getButtonIsLoop().getLoop().getSlot(loopASlotIndex)
        		    .setTouchUpMoment(new Moment(XPad.appScreen.getButtonIsLoop().getLoop().getStartMoment()));
                }
        		
        		if (holdButton) 
        		    Sound.stopSound(soundSlotNumber);
        	}
        });
	}
	
	/**
     * <code>
     *     <p>Define a new button with style
     * </code>
     * @author Ho Hai Vu
     */
	public MyButton() {
		super(null, Config.getButtonDefaultStyle());
	}
	
	public int getButtonIndex() {
	    return index;
	}
	
	public boolean hold() {
	    return holdButton;
	}
	
	public void setHold(boolean newCondition) {
	    holdButton = newCondition;
	}
	
	public boolean loop() {
        return loopSound;
    }
    
    public void setLoop(boolean newCondition) {
        loopSound = newCondition;
    }
	
	/**
     * <code>
     *     <p>Set button Image
     * </code>
     * @author Ho Hai Vu
     */
	public void setButtonStyle(int loopStyle) {
	    
	    if (loopStyle == Config.DEFAULT_STYLE) {
	        this.setStyle(Config.getButtonDefaultStyle());
	    }
	    else if (loopStyle == Config.FUNC_STYLE) {
	        this.setStyle(Config.getButtonFuncStyle());
	    }
	    else if (loopStyle == Config.LOOP_FUNC_STYLE) {
            this.setStyle(Config.getButtonLoopFuncStyle());
        }
	    else if (loopStyle == Config.PLAY_FUNC_STYLE) {
            this.setStyle(Config.getButtonPlayFuncStyle());
        }
	    else if (loopStyle == Config.LOOP_TUNE_STYLE) {
	        this.setStyle(Config.getButtonLoopTuneStyle());
	    }
	    else if (loopStyle == Config.LOOP_SOUND_STYLE) {
	        this.setStyle(Config.getButtonLoopSoundStyle());
	    }
	} 
	
}
