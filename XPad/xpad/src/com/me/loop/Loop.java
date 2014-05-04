package com.me.loop;

import java.util.Date;

import com.me.screen.AppScreen;
import com.me.setup.Config;
import com.me.setup.Sound;
import com.me.time.Moment;
import com.me.xpad.XPad;


/**
 * <code>
 *  <p>Package name: com.me.loop
 *  <p>Class name: Timer
 *  <p>Description: This class 
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class Loop {
    
    private LoopSlot[] tune;
    
    private Date startMoment;
    private long stopMoment;
    
    private int index;
    
    public Loop() {
        
        tune = new LoopSlot[100];
        startMoment = new Date();
        index = 0;
    }
    
    public void increaseIndex() {
        
        index++;
    }
    
    public int getIndex() {
        
        return index;
    }
    
    public void createNewSlot(int buttonIsTouched) {
        
        tune[index] = new LoopSlot(buttonIsTouched);
        index++; 
    }
    
    public LoopSlot getSlot(int slotIndex) {
        return tune[slotIndex];
    }
    
    public Date getStartMoment() {
        return startMoment;
    }
    
    public void stopLoop(Date stopTime) {
        
        stopMoment = (stopTime.getTime() - startMoment.getTime()) / 100;
    }
    
    Runnable playTune = new Runnable() {
        
        @Override
        public void run() {
            // TODO Auto-generated method stub
            int indexTouchDown = 0;
            int indexTouchUp = 0;
            
            boolean down = true;
            
            while (running) {
                Moment currentMoment = new Moment(startMoment);
                
                if (index == 0) {
                    running = false;
                }
                else if (index == 1) {
                    if (down && (currentMoment.getMoment() % stopMoment == tune[0].getTouchDownMoment().getMoment())) {
                        
                        down = false;
                        
                        Sound.playSound(tune[0].getButton());
                        
                        XPad.appScreen.getSoundButton(tune[0].getButton()).setButtonStyle(Config.LOOP_TUNE_STYLE);
                    }
                    else if (!down && (currentMoment.getMoment() % stopMoment == tune[0].getTouchUpMoment().getMoment())) {
                        
                        down = true;
                        
                        if (XPad.appScreen.getSoundButton(tune[0].getButton()).hold()) {
                            Sound.stopSound(tune[0].getButton());
                        }
                        
                        XPad.appScreen.getSoundButton(tune[0].getButton()).setButtonStyle(Config.DEFAULT_STYLE);
                    }
                }
                else if (index > 1) {
                
                    while ((currentMoment.getMoment() % stopMoment == tune[indexTouchDown].getTouchDownMoment().getMoment()) || 
                            (currentMoment.getMoment() % stopMoment == tune[indexTouchUp].getTouchUpMoment().getMoment())) {
                        
                        if (currentMoment.getMoment() % stopMoment == tune[indexTouchDown].getTouchDownMoment().getMoment()) {
                            
                            Sound.playSound(tune[indexTouchDown].getButton());
                            XPad.appScreen.getSoundButton(tune[indexTouchDown].getButton()).setButtonStyle(Config.LOOP_TUNE_STYLE);
                            //if (tune[indexTouchDown + 1] == null)
                            if (indexTouchDown == index - 1)
                                indexTouchDown = 0;
                            else
                                indexTouchDown++;
                        }
                        else if (currentMoment.getMoment() % stopMoment == tune[indexTouchUp].getTouchUpMoment().getMoment()) {
                            
                            if (XPad.appScreen.getSoundButton(tune[indexTouchUp].getButton()).hold()) {
                                Sound.stopSound(tune[indexTouchUp].getButton());
                            }
                            XPad.appScreen.getSoundButton(tune[indexTouchUp].getButton()).setButtonStyle(Config.DEFAULT_STYLE);
                            //if (tune[indexTouchUp + 1] == null) {
                            if (indexTouchUp == index - 1) 
                                indexTouchUp = 0; 
                            else
                                indexTouchUp++;
                        }
                    }
                }
            }
        }
    };
    
    private boolean running = false;
    
    Thread playTuneThread = new Thread(playTune);
    
    public void playLoopTune() {
        running = true;
        playTuneThread.start();
    }
    
    public void stopLoopTune() {
        running = false;
        
        for (int i = 0; i <= 15; i ++) {
            XPad.appScreen.getSoundButton(i).setButtonStyle(Config.DEFAULT_STYLE);
        }
    }
}
