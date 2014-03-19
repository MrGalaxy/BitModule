package com.github.mrgalaxy.bit_module.lib;

import src.run.Game;
import src.run.GameVersion;

/**
 * Project_Engine.
 * 
 * Engine Client Reference Class
 * 
 * @author Mr_Galaxy
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Reference
{
    public static final String DISPLAY = "Display";
	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH / 16 * 9; // Calculation done is class 168px
	public static final int scale = 3;
    
	public static final String GAME_NAME = "Game";
    public static final String ENGINE_NAME = "BitModule";
    public static final String ENGINE_LONG_NAME = "Bit Module Engine";
	public static final String TITLE = Game.RUNNING + " " + GameVersion.GAME_VERSION;

    public static final String IS_RUNNING = "Running...";
    public static final String IS_STOPING = "Stoping...";
    public static final String BUILD_SYMBOL = Strings.ALPHA;
    
    public static final String string = "Hello";
    
}