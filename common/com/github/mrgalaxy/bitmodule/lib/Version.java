package com.github.mrgalaxy.bitmodule.lib;


/**
 * BitModule.
 * 
 * Engine Version handler class
 * [ (0.0.0) Rel: 0 ]
 * 
 * @author Mr_Galaxy
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Version
{
    public static final int MAJOR_VERSION = 0;
	public static final int MINOR_VERSION = 4;
	public static final int REVISION_VERSION = 8;
	public static final int RELEASE_VERSION = 0;
	
	public static final String ENGINE_BUILD_NUMBER = "( " + Reference.BUILD_SYMBOL + " " + MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + " ) [" + " Rel: " + RELEASE_VERSION + " ]";
	public static final String RUNNING_ENGINE_BUILD = Reference.ENGINE_NAME + " " + ENGINE_BUILD_NUMBER;
	
}