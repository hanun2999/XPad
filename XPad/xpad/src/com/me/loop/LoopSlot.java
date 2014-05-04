package com.me.loop;

import java.util.Date;

import com.me.time.Moment;

public class LoopSlot {
    private int button;
    // save when the button is touched down
    private Moment touchDownMoment;
    // save when the button is touched up
    private Moment touchUpMoment;
    
    public LoopSlot(int buttonIsTouched) {  
        
        button = buttonIsTouched;
        touchDownMoment = new Moment(new Date());
        touchUpMoment = new Moment(new Date());
    }
     
    public void setTouchDownMoment(Moment moment) {
        touchDownMoment = moment;
    }
    
    public Moment getTouchDownMoment() {
        return touchDownMoment;
    }
    
    public void setTouchUpMoment(Moment moment) {
        touchUpMoment = moment;
    }
    
    public Moment getTouchUpMoment() {
        return touchUpMoment;
    }
    
    public void setButton(int buttonIndex) {
        button = buttonIndex;
    }
    
    public int getButton() {
        return button;
    }
}
