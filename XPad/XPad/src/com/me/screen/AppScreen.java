package com.me.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.me.actor.MyStage;
import com.me.actor.MyTable;
import com.me.actor.button.LoopButton;
import com.me.actor.button.SoundButton;
import com.me.setup.Config;
import com.me.xpad.XPad;

/**
 * <code>
 *  <p>Package name: com.me.screen
 *  <p>Class name: AppScreen
 *  <p>Description: Main screen of application
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class AppScreen implements Screen {
    
 // Get width of device
    private float w = Gdx.graphics.getWidth();
    // Get height of device
    private float h = Gdx.graphics.getHeight();
    
    private Group mainGroup = new Group();
    
    private XPad mainActivity;
    
    private XPad main;
    
    /**
     * <code>
     *     <p>Define a main application screen 
     * </code>
     * @author Ho Hai Vu
     */
    
    public SelectBox<String> list = new SelectBox<String>(Config.getSoundSelectStyle());
    
	public AppScreen(final XPad xPad) {
	    
	    mainActivity = xPad;
	    
	    main = xPad;
	    
	    createStage();
        
	    //createRecordButton();
        //createPlaybackButton();
	    createFuncTable();
        createSoundTable();
        stage.addActor(mainGroup);
        
        //mainGroup.setTouchable(Touchable.disabled);
        /*stage.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (settingWindow.isVisible()) {
                    Date now = new Date();
                    
                    if (numbOfTouch == 0) {
                        numbOfTouch++;
                    }
                    else if (numbOfTouch == 1) {
                        numbOfTouch++;
                        firstTouch = new Date();
                    }
                    else if (numbOfTouch == 2) {
                        if (now.getTime() - firstTouch.getTime() < 1000)
                            numbOfTouch++;
                        else {
                            numbOfTouch = 2;
                            firstTouch = new Date();
                        }
                    }
                        
                    if (numbOfTouch == 3) {
                        settingWindow.setVisible(false);
                        numbOfTouch = 0;
                    }
                }
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });*/
        
        /*
        list.setItems("1", "2", "3", "4", "5");
        list.setSize(h/4, h/8);
        list.setPosition(w / 2 + h/8, h/2);
        list.setMaxListCount(3);
        stage.addActor(list);
        list.setVisible(false);*/
	}
	
	private MyStage stage;
	
    public void createStage() {
        // Create state
        stage = new MyStage(w, h, false);
        stage.clear();      
        stage.setBackground(Gdx.files.internal("wallpaper/wallpaper.png"));
    }
    
    public Group getMainGroup() {
        return mainGroup;
    }
    
    public MyStage getStage() {
        return stage;
    }
    
  //************************************************************************************************
    
    private SoundButton configButton;    
    
    public void createConfigButton() {
        // Create a config button
        configButton = new SoundButton();
        configButton.setButtonStyle(Config.FUNC_STYLE);
        configButton.setText("Setup");
        configButton.setSize(3 * h / 16, h / 4);
        configButton.setPosition(w - h / 4, h - h / 4);
        configButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                mainActivity.setScreen(XPad.configScreen);
                
                Gdx.app.log("my app", "Pressed");
                // switch to config screen when touch into config button
                main.setScreen(main.configScreen);
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        
    }
    
  //************************************************************************************************
    
   /* private MyButton recordButton;
    private boolean recording = false;
    
    public void createRecordButton() {
        // Create a record sound button
        recordButton = new MyButton();
        recordButton.setText("Record");
        recordButton.setSize(h/4, h/4);
        recordButton.setPosition(0, h-h/4);
        recordButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (!recording) {           
                }               
                else {
                }
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Released");
            }
        });
        
        stage.addActor(recordButton);
    }*/
    
  //************************************************************************************************
    
  /*  private MyButton playbackButton;
    private Music playBack;
    private boolean playing = false;
    
    public void createPlaybackButton() {
        
        if (Gdx.files.internal("record/defaultRecord.3gpp").exists()) {
            playBack = Gdx.audio.newMusic(Gdx.files.internal("record/defaultRecord.3gpp"));
        }
        
        // Create play back button
        playbackButton = new MyButton();
        playbackButton.setText("Play");
        playbackButton.setSize(h/4, h/4);
        playbackButton.setPosition(0, h-h/2);
        playbackButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {             
                if (!playing) {
                    if (Gdx.files.internal("record/defaultRecord.3gpp").exists()) {
                        playBack.play();
                        playbackButton.setText("Playing");
                    }
                }
                else {
                    if (Gdx.files.internal("record/defaultRecord.3gpp").exists()) {
                        playBack.stop();
                        playbackButton.setText("Play");
                    }
                }
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Released");
            }
        });
        
        stage.addActor(playbackButton);
    }*/
    
  //************************************************************************************************
    
    private LoopButton loopA;
    
    public void createLoopAButton() {
        
        loopA = new LoopButton("LoopA", 0, h/4);
        //stage.addActor(loopA);
    }
  
    private LoopButton loopB;
    
    public void createLoopBButton() {
        
        loopB = new LoopButton("LoopB", 0, 0);
        //stage.addActor(loopB);
    }
    
    public boolean anyButtonIsLoop() {
        if (loopA.isLoop() || loopB.isLoop())
            return true;
        else
            return false;
    }
    
    public LoopButton getButtonIsLoop() {
        if (loopA.isLoop())
            return loopA;
        else if (loopB.isLoop())
            return loopB;
        else 
            return null;
    }
    
    private MyTable funcTable;
    private SoundButton Btn1;
    private SoundButton Btn2;
    private SoundButton Btn3;
    private SoundButton Btn4;
    private SoundButton Btn5;
    
    public void createFuncTable() {
        
        createConfigButton();
        createLoopAButton();
        createLoopBButton();
        
        Btn1 = new SoundButton();
        Btn2 = new SoundButton();
        Btn3 = new SoundButton();
        Btn4 = new SoundButton();
        Btn5 = new SoundButton();
        
        Btn1.setSize(3*h/16, h/4);
        Btn1.setSize(3*h/16, h/4);
        Btn1.setSize(3*h/16, h/4);
        Btn1.setSize(3*h/16, h/4);
        Btn1.setSize(3*h/16, h/4);
        
        funcTable = new MyTable(Config.FUNC_TABLE);
        
        funcTable.addFuncButton(configButton);
        funcTable.addFuncButton(Btn1);
        funcTable.row();
        funcTable.addFuncButton(Btn2);
        funcTable.addFuncButton(Btn3);
        funcTable.row();
        funcTable.addFuncButton(Btn4);
        funcTable.addFuncButton(Btn5);
        funcTable.row();
        funcTable.addFuncButton(loopA);
        funcTable.addFuncButton(loopB);
        
        mainGroup.addActor(funcTable);
    }
    
    //************************************************************************************************
    
    private MyTable soundTable;
    private  SoundButton[] soundButton = new SoundButton[Config.NUMB_OF_SOUND_BUTTON]; 
    
    public void createSoundTable() {
        // create all sound button       
        for (int i = 0; i <= Config.NUMB_OF_SOUND_BUTTON - 1; i++) {
            soundButton[i] = new SoundButton(i);
        }
        
        // create 4x4 table with sound button
        soundTable = new MyTable(Config.SOUND_TABLE);
        for (int i = 0; i <= Config.NUMB_OF_SOUND_BUTTON - 1; i++) {
            if (i % 5 == 0) 
                // add new row
                soundTable.row();
            // add button to table
            soundTable.addSoundButton(soundButton[i]);            
        }      
        
        mainGroup.addActor(soundTable);
    }
    
    public  SoundButton getSoundButton(int index) {
        return soundButton[index];
    }
    //************************************************************************************************
    /*
    private Image blurImage = new Image(Config.getWallpaperSkin().getDrawable("ConfBackground"));
    
    public void createBlurImage() {
        stage.addActor(blurImage);
        blurImage.setVisible(false);
    }
    
    public Image getBlurImage() {
        return blurImage;
    }
    
    //************************************************************************************************

    private SettingWindow settingWindow;

    public void createSettingWindow() {
        settingWindow = new SettingWindow();
        stage.addActor(settingWindow);
        settingWindow.setVisible(false);
    }

    public SettingWindow getSettingWindow() {
        return settingWindow;
    }
    
    //************************************************************************************************
    
    private SelectSoundWindow selectSoundWindow;
    
    public void createSelectSoundWindow() {
        selectSoundWindow = new SelectSoundWindow();
        stage.addActor(selectSoundWindow);
        selectSoundWindow.setVisible(false);
    }
    
    public SelectSoundWindow getSelectSoundWindow() {
        return selectSoundWindow;
    }*/
    
    //************************************************************************************************
    
	/**
     * <code>
     *     <p> Override render method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
	}

	/**
     * <code>
     *     <p> Override resize method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
	}

	/**
     * <code>
     *     <p> Override show method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	/**
     * <code>
     *     <p> Override hide method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void hide() {
	}

	/**
     * <code>
     *     <p> Override resize method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void pause() {
	}

	/**
     * <code>
     *     <p> Override resume method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void resume() {
		
	}

	/**
     * <code>
     *     <p> Override dispose method 
     * </code>
     * @author Ho Hai Vu
     */
	@Override
	public void dispose() {
		
	}
	
	
}
