package com.me.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.me.setup.Config;

public class SettingWindow extends Window{
    
    private static float h = Gdx.graphics.getHeight();
    private static float w = Gdx.graphics.getWidth();
    
    private MyButton btn1 = new MyButton();
    private MyButton btn2 = new MyButton();
    private MyButton btn3 = new MyButton();
    private MyButton btn4 = new MyButton();
    private MyButton btn5 = new MyButton();
    
    private SelectBox<String> sound = new SelectBox<String>(Config.soundSelectStyle);
    
    public SettingWindow() {
        super("Setting", Config.getConfigWindowStyle());
        
        this.setSize(w / 2, h / 2);
        this.setPosition(w / 4, h / 4);
        this.setMovable(false);
        //this.setSkin(Config.getButtonSkin());
        
        Config.getFont();
        
        this.setSkin(Config.defaultSkin);
        
        sound.setItems("1", "2", "3", "4", "5");
        sound.setSelected("4");
        
       // this.add("abc").size(h/4, h/8);
        this.add(btn1).size(h/4, h/8);
        this.row();
        //this.add("abc").size(h/4, h/8);
        this.add(btn2).size(h/4, h/8);
        this.row();
        //this.add("abc").size(h/4, h/8);
        this.add(sound).size(h/4, h/8);
        this.row();
        this.add(btn4).size(h/4, h/8);
        this.add(btn5).size(h/4, h/8);
    }
}
