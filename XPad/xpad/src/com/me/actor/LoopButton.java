package com.me.actor;

import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.loop.Loop;
import com.me.setup.Config;

public class LoopButton extends TextButton{
    
    private static final float h = Gdx.graphics.getHeight();
    
    private boolean isLoop = false;
    private boolean isPlay = false;
    
    private Loop loop;
    
    public LoopButton(String name, float x, float y) {
        super(name, Config.getButtonFuncStyle());
        this.setSize(3*h/16, h/4);
        this.setPosition(x, y);
        this.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                if (!isLoop && !isPlay) {
                    loop = new Loop();
                    isLoop = true;
                } 
                else if (isLoop && !isPlay){
                    isLoop = false;
                    isPlay = true;
                    loop.stopLoop(new Date());
                    loop.playLoopTune();
                }
                else if (!isLoop && isPlay){
                    isPlay = false;
                    loop.stopLoopTune();
                }
                
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (!isLoop && !isPlay) {
                    setButtonStyle(Config.FUNC_STYLE);
                } 
                else if (isLoop && !isPlay) {
                    setButtonStyle(Config.LOOP_FUNC_STYLE);
                }
                else if (!isLoop && isPlay) {
                    setButtonStyle(Config.PLAY_FUNC_STYLE);
                }
            }
        });
    }
    
    public boolean isLoop() {
        if (isLoop) 
            return true;
        else
            return false;
    }
    
    public Loop getLoop() {
        return loop;
    }
    
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
    } 
}
