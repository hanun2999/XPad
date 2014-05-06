package com.me.time;

import java.util.Date;

public class Moment{
    
    private Date date;
    
    private long currentMoment;
    
    public Moment(Date baseTime) {
        
        date = new Date();
         
        currentMoment = (date.getTime() - baseTime.getTime()) / 100;
        
    }
    
    public long getMoment() {
        return currentMoment;
    }
}
