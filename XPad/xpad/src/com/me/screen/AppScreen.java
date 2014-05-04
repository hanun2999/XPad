package com.me.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.me.actor.LoopButton;
import com.me.actor.MyButton;
import com.me.actor.MyStage;
import com.me.actor.MyTable;
import com.me.actor.SettingWindow;
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
    
    /**
     * <code>
     *     <p>Define a main application screen 
     * </code>
     * @author Ho Hai Vu
     */
	public AppScreen(final XPad xPad) {
	    
	    createStage();
        
	    //createRecordButton();
        //createPlaybackButton();
	    createFuncTable();
        createSoundTable();
        
	}
	
	private MyStage stage;
	
	public SettingWindow setting;
	
    public void createStage() {
        // Create state
        stage = new MyStage(w, h, false);
        stage.clear();      
        stage.setBackground(Gdx.files.internal("wallpaper/wallpaper.png"));
    }
    
  //************************************************************************************************
    
    private MyButton configButton;    
    
    public void createConfigButton() {
        // Create a config button
        configButton = new MyButton();
        configButton.setText("Setup");
        configButton.setSize(3 * h / 16, h / 4);
        configButton.setPosition(w - h / 4, h - h / 4);
        configButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Pressed");
                // switch to config screen when touch into config button
                //testRecord.setScreen(testRecord.configScreen);
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("my app", "Released");
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
    private MyButton Btn1;
    private MyButton Btn2;
    private MyButton Btn3;
    private MyButton Btn4;
    private MyButton Btn5;
    
    public void createFuncTable() {
        
        createConfigButton();
        createLoopAButton();
        createLoopBButton();
        
        Btn1 = new MyButton();
        Btn2 = new MyButton();
        Btn3 = new MyButton();
        Btn4 = new MyButton();
        Btn5 = new MyButton();
        
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
        
        // add table to stage
        stage.addActor(funcTable);
    }
    
    //************************************************************************************************
    
    private MyTable soundTable;
    private  MyButton[] soundButton = new MyButton[Config.NUMB_OF_SOUND_BUTTON]; 
    
    public void createSoundTable() {
        // create all sound button       
        for (int i = 0; i <= Config.NUMB_OF_SOUND_BUTTON - 1; i++) {
            soundButton[i] = new MyButton(i);
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
        
        // add table to stage
        stage.addActor(soundTable);
        
        setting = new SettingWindow();
        stage.addActor(setting);
        setting.setVisible(false);
    }
    
    public  MyButton getSoundButton(int index) {
        return soundButton[index];
    }
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
