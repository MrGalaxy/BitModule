package com.github.mrgalaxy.bit_module;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.github.mrgalaxy.bit_module.lib.Reference;

/**
 * BitModule.
 * 
 * main game Engine Class
 * 
 * @author Mr_Galaxy
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */

public class BitModule extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;

    public static int WIDTH = 300;
    public static int HIGHT = WIDTH / 16 * 9;// = 168
    public static int SCALE = 3; // From 1 - 5
    
    public static BitModule engine;
    
    private JFrame frame;
    
    public boolean running = false;
    
    public int tickCount = 0;

    
    public BitModule()
    {
        setMinimumSize(new Dimension(WIDTH * SCALE, HIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH * SCALE, HIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH * SCALE, HIGHT * SCALE));
        
        frame = new JFrame(Reference.ENGINE_NAME); // Window Name -
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.setVisible(true);
    }
    
    public synchronized void start()
    {
        running = true;
        new Thread(this).start();
    }
    
    public synchronized void stop()
    {
        running = false;
    }
    
    public void run()
    {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 60D;
        
        int ticks = 0;
        int frames = 0;
        
        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            
            while (delta >= 1)
            {
                ticks++;
                tick();
                delta -= 1;
                
                shouldRender = true;
            }
            
            try
            {
                Thread.sleep(2);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
            if (shouldRender)
            {
                frames++;
                render();
            }
            
            if (System.currentTimeMillis() - lastTimer >= 1000)
            {
                lastTimer += 1000;
                
                System.out.println("Ticks; " + ticks + ", " + "FPS; " + frames);
                
                frames = 0;
                ticks = 0;
            }
        }
    }
    
    public void tick()
    {
        
    }
    
    public void render()
    {
        
    }
    
    public static void main(String[]args)
    {
        new BitModule().start();
    }
    
}