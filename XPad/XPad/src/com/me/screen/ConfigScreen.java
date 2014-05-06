package com.me.screen;

import java.util.Date;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.me.actor.MyStage;
import com.me.actor.MyTable;
import com.me.actor.button.ShowConfigWindowButton;
import com.me.actor.button.SoundButton;
import com.me.actor.window.SelectSoundWindow;
import com.me.actor.window.SettingWindow;
import com.me.setup.Config;
import com.me.xpad.XPad;

/**
 * <code>
 *  <p>Package name: com.me.screen
 *  <p>Class name: ConfigScreen
 *  <p>Description: Config screen of application
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class ConfigScreen implements Screen{

	private MyStage stage;
	private Group mainGroup = new Group();
	
	private static float w = Gdx.graphics.getWidth();
	private static float h = Gdx.graphics.getHeight();

	private XPad mainActivity;
	
	public ConfigScreen(final XPad xPad) {
                     
	    mainActivity = xPad;
    
        stage = new MyStage(w, h, false);
        stage.clear();      
        stage.setBackground(Gdx.files.internal("wallpaper/wallpaper.png"));
        
        createConfigTable();
        createConfigButton();
        
        stage.addActor(mainGroup);
        
        createBlurImage();
        createSettingWindow();
        createSelectSoundWindow();
	}
	
	public Group getMainGroup() {
	    return mainGroup;
	}
	
	//************************************************************************************************
	
	private SoundButton configButton;    
    
    public void createConfigButton() {
        // Create a config button
        configButton = new SoundButton();
        
        configButton.setText("Setup");
        configButton.setSize(3 * h / 16, h / 4);
        configButton.setPosition(0, h - h / 4);
        configButton.setButtonStyle(Config.IFUNC_STYLE);
        
        configButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                mainActivity.setScreen(XPad.appScreen);
                
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        mainGroup.addActor(configButton);
    }
	
	//************************************************************************************************

    private MyTable configTable;
    private  ShowConfigWindowButton[] showConfigWindowButton = new ShowConfigWindowButton[Config.NUMB_OF_SOUND_BUTTON]; 
    
    public void createConfigTable() {
        // create all sound button       
        for (int i = 0; i <= Config.NUMB_OF_SOUND_BUTTON - 1; i++) {
            showConfigWindowButton[i] = new ShowConfigWindowButton(i);
        }
        
        // create 4x4 table with sound button
        configTable = new MyTable(Config.SOUND_TABLE);
        
        for (int i = 0; i <= Config.NUMB_OF_SOUND_BUTTON - 1; i++) {
            if (i % 5 == 0) 
                // add new row
                configTable.row();
            // add button to table
            configTable.addSoundButton(showConfigWindowButton[i]);            
        }      
        
        mainGroup.addActor(configTable);
    }
    
    public  ShowConfigWindowButton getConfigWindowButton(int index) {
        return showConfigWindowButton[index];
    }
    //************************************************************************************************
    
    private Image blurImage = new Image(Config.getWallpaperSkin().getDrawable("ConfBackground"));
    private int numOfTouch = 0;
    private Date firstTouch;
    
    public void createBlurImage() {
        
        blurImage.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                
                if (settingWindow.isVisible()) {
                    Date now = new Date();
                    
                    if (numOfTouch == 0) {
                        numOfTouch++;
                        firstTouch = new Date();
                    }
                    else if (numOfTouch == 1) {
                        if (now.getTime() - firstTouch.getTime() < 1000)
                            numOfTouch++;
                        else {
                            numOfTouch = 1;
                            firstTouch = new Date();
                        }
                    }
                        
                    if (numOfTouch == 2) {
                        settingWindow.setVisible(false);
                        blurImage.setVisible(false);
                        mainGroup.setTouchable(Touchable.enabled);
                        numOfTouch = 0;
                    }
                }
                
                return true;
            }
            
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        
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
    }
    
    //************************************************************************************************

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		stage.getViewport().update(width, height, false);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
