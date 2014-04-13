package src.run;

import com.github.mrgalaxy.bitmodule.BitModule;
import com.github.mrgalaxy.bitmodule.lib.Reference;
import com.github.mrgalaxy.bitmodule.lib.Strings;
import com.github.mrgalaxy.bitmodule.lib.Version;

/**
 * Fear Atlas.
 * 
 * Main Fear Atlas Class
 * 
 * @author Mr_Galaxy
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Game extends BitModule
{
    private static final long serialVersionUID = 1L;
    
    public static Game game;
    
    
    public static void main(String[]args)
    {
        System.out.println("Started...");
        
        System.out.println(Strings.SPACE);
        System.out.println("Engine: " + Reference.ENGINE_NAME);
        System.out.println("Engine Version: " + Version.ENGINE_BUILD_NUMBER);
        
        System.out.println(Strings.SPACE);
        System.out.println("Game: " + Fear_Atlas.NAME);
        System.out.println("Game Version: " + Fear_Atlas.VERSION);
        
        System.out.println(Strings.SPACE);
        
        new BitModule().start();
    }
}