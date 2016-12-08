/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author FreeYourMindGamer
 */
public class Main {
    private static Game game;
    private static final int FRAMERATE = 120;
    
    public static void main(String[] args) {
        initDisplay();      // Initialize basic display window
        initGL();           // Initialize openGL
        
        initGame();         // Initialize the game objects and variables
        
        gameLoop();         // Runs main game loop
        cleanUp();          // Cleans memory
    }
    
    private static void initGame() {
        game = new Game();
    }
    
    private static void getInput() {
        game.getInput();
    }
    
    private static void update() {
        game.update();
    }
    
    private static void render() {
            // All color information is stored in 
            // color buffer, clearing the buffer
            // provides a blank slate to draw on
            glClear(GL_COLOR_BUFFER_BIT);
            glLoadIdentity();
            game.render();
            // Update shows what is drawn so far
            Display.update();
            Display.sync(FRAMERATE);
    }
    
    private static void gameLoop() {
        while (!Display.isCloseRequested()) {
            getInput();
            update();
            render();
        }
    }
    

    
    private static void initGL() {
        glMatrixMode(GL_PROJECTION);
        // glLoadIdentity loads the identity matrix to clear whatever is being 
        // displayed
        glLoadIdentity();
        // sets up an orthographic display from x to x, y to y,
        // 3D depth from 5th arg to 6th arg
        // coordinates given allow the drawing to be resolution-independent
        glOrtho(0,Display.getWidth(),0,Display.getHeight(),-1,1);
        glMatrixMode(GL_MODELVIEW);
        
        // clears color to colors specified,
        // last arg is opacity
        glClearColor(0,0,0,1);
        
        // Disables testing for 3D
        glDisable(GL_DEPTH_TEST);
    }
    
    private static void cleanUp() {
        Display.destroy();
        Keyboard.destroy();
    }
    
    private static void initDisplay() {
        // Create display
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            // Set VSync allows the framerate to snyc with monitor naturally
            Display.setVSyncEnabled(true);
            Keyboard.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
