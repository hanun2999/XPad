package com.me.actor.button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
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
public class SoundButton extends TextButton{
	
    private int loopASlotIndex;
    private int index;
    
    private boolean hold = false;
    private boolean loop = false;
    private boolean looping = false;
    
    /**
     * <code>
     *     <p>Define a new button with style and input event
     * </code>
     * @author Ho Hai Vu
     */
	public SoundButton(final int soundSlotNumber) {
        super(null, Config.getButtonDefaultStyle());
        
        index = soundSlotNumber;
        
		this.addListener(new InputListener() {
        	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        	    
        	    if (XPad.appScreen.anyButtonIsLoop()) {
        	        
        	        loopASlotIndex = XPad.appScreen.getButtonIsLoop().getLoop().getIndex();
        	        
        	        XPad.appScreen.getButtonIsLoop().getLoop().createNewSlot(soundSlotNumber);
        	        
        	        XPad.appScreen.getButtonIsLoop().getLoop().getSlot(loopASlotIndex)
        	        .setTouchDownMoment(new Moment(XPad.appScreen.getButtonIsLoop().getLoop().getStartMoment()));
        	    }
        	    
        		Sound.stopSound(soundSlotNumber);
        		
        		if (loop && !looping) {
        		    Sound.loopSound(soundSlotNumber);
        		    if (!hold) {
        		        looping = true;
        		        setButtonStyle(Config.IDEFAULT_STYLE);
        		    }
        		}
        		else if (loop && looping) {
        		    looping = false;
                    setButtonStyle(Config.DEFAULT_STYLE);
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
        		
        		if (hold) 
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
	public SoundButton() {
		super(null, Config.getButtonDefaultStyle());
	}
	
	public int getButtonIndex() {
	    return index;
	}
	
	public boolean isHold() {
	    return hold;
	}
	
	public void setHold(boolean newCondition) {
	    hold = newCondition;
	}
	
	public boolean isLoop() {
	    return loop;
    }
    
    public void setLoop(boolean newCondition) {
        loop = newCondition;
    }
	
	/**
     * <code>
     *     <p>Set button Image
     * </code>
     * @author Ho Hai Vu
     */
    public void setButtonStyle(int buttonStyle) {
        
        if (buttonStyle == Config.DEFAULT_STYLE) {
            this.setStyle(Config.getButtonDefaultStyle());
        }
        else if (buttonStyle == Config.IDEFAULT_STYLE) {
            this.setStyle(Config.getButtonIDefaultStyle());
        }
        else if (buttonStyle == Config.LOOP_TUNE_STYLE) {
            this.setStyle(Config.getButtonLoopTuneStyle());
        }
        else if (buttonStyle == Config.FUNC_STYLE) {
            this.setStyle(Config.getButtonFuncStyle());
        }
        else if (buttonStyle == Config.IFUNC_STYLE) {
            this.setStyle(Config.getButtonIFuncStyle());
        }
    } 
	
}
