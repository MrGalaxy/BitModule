package com.github.mrgalaxy.bitmodule.gfx;

/**
 * BitModule.
 * 
 * screen Class
 * 
 * @author Mr_Galaxy
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class Screen
{
    public static final int MAP_SIZE = 64;
    public static final int MAP_SIZE_MASK = MAP_SIZE -1;
    
    public int[] tiles = new int [MAP_SIZE * MAP_SIZE];
    public int[] colours = new int [MAP_SIZE * MAP_SIZE * 4];
    
    public int xOffset = 0;
    public int yOffset = 0;
    
    public int width;
    public int height;
    
    public SpriteSheet sheet;
    
    public Screen(int width, int height, SpriteSheet sheet)
    {
        this.width = width;
        this.height = height;
        
        this.sheet = sheet;
        
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++)
        {
            colours[ i * 4 + 0 ] = 0xff00ff;
            colours[ i * 4 + 0 ] = 0xffff00;
            colours[ i * 4 + 0 ] = 0x00ffff;
            colours[ i * 4 + 0 ] = 0x00ff00;
        }
    }
    
    public void render(int[] pixels, int offset, int row)
    {
        for (int yTile = yOffset >> 3; yTile <= (yOffset + height) >> 3; yTile++)
        {
            int yMin = yTile * 8 - yOffset;
            int yMax = yMin + 8;
            if (yMin < 0)  yMin = 0;
            if (yMax > height) yMax = height;
            
            for (int xTile = xOffset >> 3; xTile <= (xOffset + width) >> 3; xTile++)
            {
                int xMin = xTile * 8 - xOffset;
                int xMax = xMin + 8;
                if (xMin < 0)  xMin = 0;
                if (xMax > width) xMax = width;
                
                int tileIndex = (xTile & (MAP_SIZE_MASK)) + (yTile & (MAP_SIZE_MASK)) * MAP_SIZE;
                
                for (int y = yMin; y < yMax; y++)
                {
                    int sheetPixel = ((y + yOffset) & 7) * sheet.width + ((xMin + xOffset) & 7);
                    int tilePixel = offset + xMin + y * row;
                    for (int x = xMin; x <xMax; x++)
                    {
                        int colour = tileIndex * 4 + sheet.pixels[sheetPixel++];
                        pixels[tilePixel++] = colours[colour];
                    }
                }
            }
        }
    }
}