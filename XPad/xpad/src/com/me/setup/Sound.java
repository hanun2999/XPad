package com.me.setup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * <code>
 *  <p>Package name: com.me.setup
 *  <p>Class name: Sound
 *  <p>Description: Class includes all method to process sound
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class Sound {
 
    /**
     * <code>
     *     <p>Method to set sound
     * </code>
     * @author Ho Hai Vu
     */
	public static void setSound(int soundSlotNumber, String name, FileHandle files) {
	    
		Config.setNameOfSound(soundSlotNumber, name);
		Config.getSoundsMap().put(Config.getSoundSlot(soundSlotNumber), Gdx.audio.newSound(files));
	}
	
	/**
     * <code>
     *     <p>Method to set config file
     * </code>
     * @author Ho Hai Vu
     */
	public static void playSound(int soundSlotNumber) {
	    
	    // If sound not empty, play it
		if (Config.getSoundsMap().get(Config.getSoundSlot(soundSlotNumber)) != null) {
			Config.getSoundsMap().get(Config.getSoundSlot(soundSlotNumber)).play(Config.getVolume());
		}
	}		
	
	public static void loopSound(int soundSlotNumber) {
	    if (Config.getSoundsMap().get(Config.getSoundSlot(soundSlotNumber)) != null) {
            Config.getSoundsMap().get(Config.getSoundSlot(soundSlotNumber)).loop(Config.getVolume());
        } 
	}
	
	/**
     * <code>
     *     <p>Method to set config file
     * </code>
     * @author Ho Hai Vu
     */
	public static void stopSound(int soundSlotNumber) {
	    
	 // If sound not empty, stop it
		if (Config.getSoundsMap().get(Config.getSoundSlot(soundSlotNumber)) != null) {
			Config.getSoundsMap().get(Config.getSoundSlot(soundSlotNumber)).stop();
		}
	}
}
