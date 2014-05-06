package com.me.setup;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;

/**
 * <code>
 *  <p>Package name: com.me.setup
 *  <p>Class name: Config
 *  <p>Description: This class save all setup of my application
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class Config {
	
	public static final int SLOT_0 = 0;
	public static final int SLOT_1 = 1;
	public static final int SLOT_2 = 2;
	public static final int SLOT_3 = 3;
	public static final int SLOT_4 = 4;
	public static final int SLOT_5 = 5;
	public static final int SLOT_6 = 6;
	public static final int SLOT_7 = 7;
	public static final int SLOT_8 = 8;
	public static final int SLOT_9 = 9;
	public static final int SLOT_10 = 10;
	public static final int SLOT_11 = 11;
	public static final int SLOT_12 = 12;
	public static final int SLOT_13 = 13;
	public static final int SLOT_14 = 14;
	public static final int SLOT_15 = 15;
	public static final int SLOT_16 = 16;
    public static final int SLOT_17 = 17;
    public static final int SLOT_18 = 18;
    public static final int SLOT_19 = 19;
	
	public static final int SOUND_BUTTON_0 = 0;
	public static final int SOUND_BUTTON_1 = 1;
	public static final int SOUND_BUTTON_2 = 2;
	public static final int SOUND_BUTTON_3 = 3;
	public static final int SOUND_BUTTON_4 = 4;
	public static final int SOUND_BUTTON_5 = 5;
	public static final int SOUND_BUTTON_6 = 6;
	public static final int SOUND_BUTTON_7 = 7;
	public static final int SOUND_BUTTON_8 = 8;
	public static final int SOUND_BUTTON_9 = 9;
	public static final int SOUND_BUTTON_10 = 10;
	public static final int SOUND_BUTTON_11 = 11;
	public static final int SOUND_BUTTON_12 = 12;
	public static final int SOUND_BUTTON_13 = 13;
	public static final int SOUND_BUTTON_14 = 14;
	public static final int SOUND_BUTTON_15 = 15;
	public static final int SOUND_BUTTON_16 = 16;
    public static final int SOUND_BUTTON_17 = 17;
    public static final int SOUND_BUTTON_18 = 18;
    public static final int SOUND_BUTTON_19 = 19;
	
	public static final int MAX_SLOT = 20;
	public static final int NUMB_OF_SOUND_BUTTON = 20;
	
	public static final int DEFAULT_STYLE = 0;
    public static final int IDEFAULT_STYLE = 1;
    public static final int MODE_STYLE = 2;
    public static final int IMODE_STYLE = 3;
	public static final int FUNC_STYLE = 4;
	public static final int IFUNC_STYLE = 5;
	public static final int LOOP_FUNC_STYLE = 6;
	public static final int PLAY_FUNC_STYLE = 7;
	public static final int LOOP_TUNE_STYLE = 8;
	public static final int CONFIG_STYLE = 9;
	public static final int ICONFIG_STYLE = 10;
	public static final int SOUND_CONFIG_STYLE = 11;
	
	public static final int SOUND_TABLE = 0;
	public static final int FUNC_TABLE = 1;
	
	public static final int LOOP_CONFIG_BUTTON = 0;
	public static final int HOLD_CONFIG_BUTTON = 1;
	/*
	************************************************************
	*/
	
	/*
     * Button style
     */
    // Texture atlas of button images
    private static TextureAtlas buttonAtlas = new TextureAtlas(
            Gdx.files.internal("button/Buttons.pack"));
    // Button skin is generated from atlas of button images
    private static Skin buttonSkin = new Skin(buttonAtlas);
    // Name button's font 
    private static BitmapFont fontNormal = new BitmapFont(Gdx.files.internal("font/hdpi.fnt"), false);
    private static BitmapFont fontSpecial = new BitmapFont(Gdx.files.internal("font/hdpi.fnt"), false);
    // Default style of button, include image of button and Name's font
    private static TextButtonStyle buttonDefaultStyle = new TextButtonStyle(
            buttonSkin.getDrawable("BtnDark"), 
            buttonSkin.getDrawable("BtnLight"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonIDefaultStyle = new TextButtonStyle(
            buttonSkin.getDrawable("BtnLight"), 
            buttonSkin.getDrawable("BtnDark"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonModeStyle = new TextButtonStyle(
            buttonSkin.getDrawable("BtnDark"), 
            buttonSkin.getDrawable("BtnDark"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonIModeStyle = new TextButtonStyle(
            buttonSkin.getDrawable("BtnLight"), 
            buttonSkin.getDrawable("BtnLight"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonFuncStyle = new TextButtonStyle(
            buttonSkin.getDrawable("FuncBtnDark"), 
            buttonSkin.getDrawable("FuncBtnLight"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonIFuncStyle = new TextButtonStyle(
            buttonSkin.getDrawable("FuncBtnLight"), 
            buttonSkin.getDrawable("FuncBtnDark"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonLoopFuncStyle = new TextButtonStyle(
            buttonSkin.getDrawable("FuncBtnLight"), 
            buttonSkin.getDrawable("LoopFuncBtnLight"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonPlayFuncStyle = new TextButtonStyle(
            buttonSkin.getDrawable("LoopFuncBtnLight"), 
            buttonSkin.getDrawable("BtnDark"), 
            null, fontNormal);
    
    // Loop style of button, include image of button and Name's font
    private static TextButtonStyle buttonLoopTuneStyle = new TextButtonStyle(
            buttonSkin.getDrawable("LoopBtnLight"), 
            buttonSkin.getDrawable("BtnLight"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonConfigStyle = new TextButtonStyle(
            buttonSkin.getDrawable("ModeFuncBtnDark"), 
            buttonSkin.getDrawable("ModeFuncBtnLight"), 
            null, fontSpecial);
    
    private static TextButtonStyle buttonIConfigStyle = new TextButtonStyle(
            buttonSkin.getDrawable("ModeFuncBtnLight"), 
            buttonSkin.getDrawable("ModeFuncBtnDark"), 
            null, fontSpecial);
    
    private static TextButtonStyle buttonSoundConfigStyle = new TextButtonStyle(
            buttonSkin.getDrawable("SoundFuncBtn"), 
            buttonSkin.getDrawable("SoundFuncBtn"), 
            null, fontNormal);
    
    private static TextButtonStyle buttonLoopSoundStyle = new TextButtonStyle(
            buttonSkin.getDrawable("BtnLight"), 
            buttonSkin.getDrawable("BtnDark"), 
            null, fontNormal);
	
	public static Skin getButtonSkin() {
	    //buttonSkin.
	    return buttonSkin;
	}
	
	/**
	 * Method to get style of button
	 */
	public static TextButtonStyle getButtonDefaultStyle() {
	    return buttonDefaultStyle;
	}
	
	public static TextButtonStyle getButtonIDefaultStyle() {
        return buttonIDefaultStyle;
    }
	
	public static TextButtonStyle getButtonModeStyle() {
        return buttonModeStyle;
    }
    
    public static TextButtonStyle getButtonIModeStyle() {
        return buttonIModeStyle;
    }
	
	public static TextButtonStyle getButtonFuncStyle() {
        return buttonFuncStyle;
    }
	
	public static TextButtonStyle getButtonIFuncStyle() {
        return buttonIFuncStyle;
    }
	
	public static TextButtonStyle getButtonLoopFuncStyle() {
        return buttonLoopFuncStyle;
    }
	
	public static TextButtonStyle getButtonPlayFuncStyle() {
        return buttonPlayFuncStyle;
    }
	
	public static TextButtonStyle getButtonLoopTuneStyle() {
	    return buttonLoopTuneStyle;
	}
	
	public static TextButtonStyle getButtonConfigStyle() {
	    return buttonConfigStyle;
	}
	
	public static TextButtonStyle getButtonIConfigStyle() {
        return buttonIConfigStyle;
    }
	
	public static TextButtonStyle getButtonSoundConfigStyle() {
        return buttonSoundConfigStyle;
    }
	
	public static void configFont() {
	    fontNormal.setScale(0.5f);
	    //fontSpecial.setScale(0.9f);
	}
	/*
	************************************************************
	*/
	
	private static WindowStyle configWindowStyle = new WindowStyle(fontNormal, Color.BLUE, null);
	
	public static WindowStyle getConfigWindowStyle() {
	    return configWindowStyle;
	}
	
    /*
    ************************************************************
    */	
	
	public static Skin defaultSkin = new Skin(new TextureAtlas(Gdx.files.internal("data/uiskin.pack")));
	
	private static TextureAtlas wallpaper = new TextureAtlas(Gdx.files.internal("wallpaper/background.pack"));
	private static Skin wallpaperSkin = new Skin(wallpaper);
	private static WindowStyle configWindowSyle = new WindowStyle(fontNormal, Color.BLACK, 
	        wallpaperSkin.getDrawable("ConfBackground"));
	
	private static ScrollPaneStyle scroll = new ScrollPaneStyle(wallpaperSkin.getDrawable("ConfBackground"),
	        defaultSkin.getDrawable("default-scroll"), defaultSkin.getDrawable("default-round-large"),
	        defaultSkin.getDrawable("default-scroll"), defaultSkin.getDrawable("default-round-large"));
	
	private static ListStyle listStyle = new ListStyle(fontNormal, Color.YELLOW, 
	        Color.WHITE, defaultSkin.getDrawable("selection"));
	
	private static SelectBoxStyle soundSelectStyle = new SelectBoxStyle(fontNormal, Color.WHITE, 
	        wallpaperSkin.getDrawable("ConfBackground"), scroll, listStyle);
	
	private static LabelStyle labelStyle = new LabelStyle(fontNormal, Color.WHITE);
	
	public static Skin getWallpaperSkin() {
	    return wallpaperSkin;
	}
	
	public static SelectBoxStyle getSoundSelectStyle() {
	    
	    return soundSelectStyle;
	}
	
	public static WindowStyle getWindowStyle() {
	   return configWindowSyle;
	}
	
	public static LabelStyle getLabelStyle() {
	    return labelStyle;
	}
	
	/*
	    ************************************************************
	    */  
	
	/*
     * Sound
     */
    // Slot to save sound
    public static String slot[]  = new String[MAX_SLOT];
    // Sounds map
    private final static HashMap<String, Sound> sounds = new HashMap<String, Sound>();
	
    /**
     * All config sound Button
     */
    public static float volume = 1f;
    
	/**
	 * <code>
	 *     <p>Method to get sounds map
	 * </code>
	 * @author Ho Hai Vu
	 * @return sound map
	 */
	public static HashMap<String, Sound> getSoundsMap() {
	    return sounds;
	}
	
	/**
     * <code>
     *     <p>Method to get sounds slot
     * </code>
     * @author Ho Hai Vu
     * @return sound slot
     */
	public static String getSoundSlot(int slotNumb) {
	    return slot[slotNumb];
	}
	
	/**
     * <code>
     *     <p>Method to set sounds slot
     * </code>
     * @author Ho Hai Vu
     */
	public static void setNameOfSound(int slotNumb, String name) {
	    slot[slotNumb] = name;
	}
	
	public static float getVolume() {
	    return volume;
	}
	
	public static void setVolume(float newVolume) {
	    volume = newVolume;
	}
	/*
	************************************************************
	*/
    
	/*
     * File
     */
    // Path of config file
    private static FileHandle configFile;
    // Information in file
    private static String fileData;
    // Array save information in file
    private static String configStr[];  
    // Array of sound path
    private static String pathSound[] = new String[MAX_SLOT];
	
    /**
     * <code>
     *     <p>Method to set path of file
     * </code>
     * @author Ho Hai Vu
     */
    public static void setFile(FileHandle file) {
        configFile = file;
    }
    
    /**
     * <code>
     *     <p>Method to get file
     * </code>
     * @author Ho Hai Vu
     * @return configFile
     */
    public static FileHandle getFile() {
        return configFile;
    }
    
    /**
     * <code>
     *     <p>Method to set file data
     * </code>
     * @author Ho Hai Vu
     */
    public static void setFileData(String data) {
        fileData = data;
    }
    
    /**
     * <code>
     *     <p>Method to get file data
     * </code>
     * @author Ho Hai Vu
     * @return fileData
     */
    public static String getFileData() {
        return fileData;
    }
    
    /**
     * <code>
     *     <p>Method to set array of data
     * </code>
     * @author Ho Hai Vu
s     */
    public static void setArrayOfData(String[] arrayOfData) {
        configStr = arrayOfData;
    }
    
    /**
     * <code>
     *     <p>Method to get data in array
     * </code>
     * @author Ho Hai Vu
     * @return configStr[slot]
     */
    public static String getDataInArray(int slot) {
        return configStr[slot];
    }
    
    /**
     * <code>
     *     <p>Method to set path of file
     * </code>
     * @author Ho Hai Vu
     */
    public static void setPathOfSound(int slotNumb, String path) {
        pathSound[slotNumb] = path;
    }
    
    /**
     * <code>
     *     <p>Method to get path of sound
     * </code>
     * @author Ho Hai Vu
     * @return pathSound[slotNumb]
     */
    public static String getPathOfSound(int slotNumb) {
        return pathSound[slotNumb];
    }
    
    /*
     ************************************************************
     */
	/*
	 * dispose
	 */
	public static void dispose() {
		buttonAtlas.dispose();
		buttonSkin.dispose();
	}
}
