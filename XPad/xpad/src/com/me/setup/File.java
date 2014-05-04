package com.me.setup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * <code>
 *  <p>Package name: com.me.setup
 *  <p>Class name: File
 *  <p>Description: Class includes all method to process file
 * </code>
 * @author Ho Hai Vu
 * @version 1.0
 */
public class File {
	
    /**
     * <code>
     *     <p>Method to set config file
     * </code>
     * @author Ho Hai Vu
     */
	public static void setConfigFile(FileHandle files) {
	    
		Config.setFile(files);
	}
	
	/**
     * <code>
     *     <p>Method to read data to array
     * </code>
     * @author Ho Hai Vu
     */
	public static void readDataToArray() {
	    
		if (Config.getFile().exists()) {
			Config.setFileData(Config.getFile().readString());
		}
		
		if (!(Config.getFileData().isEmpty())) {
		    // Get each line in file into array
			Config.setArrayOfData(Config.getFileData().split("\n"));
			for (int i = 0; i <= 31; i++) {
				if (i % 2 == 0) { // if line is even, this will be sound name
					Config.setNameOfSound((int)i/2, Config.getDataInArray(i));	
					Gdx.app.log("Name", Config.getSoundSlot((int)i/2));
				}
				else { // if line is odd, this will be path of sound
					Config.setPathOfSound((int)i/2, Config.getDataInArray(i));
					Gdx.app.log("Path", Config.getPathOfSound((int)i/2));
				}
			}
		}			
	}
}
