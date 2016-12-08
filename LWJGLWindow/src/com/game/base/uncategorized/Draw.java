/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Adam Farmelo
 */
public class Draw {
    public static void rect(float x, float y, float width, float height) {
        // Wrapper method to allow for 0 rotation
        rect(x,y,width,height,0);
    }
    
    public static void rect(float x, float y, 
            float width, float height, float rot) {
        
        // Push and pop allows each new matrix(image) to take 
        // points relative to the origin, rather than last
        // translation
        glPushMatrix();
        {
            // glTranslate takes what is being drawn and 
            // shifts it by specified values x, y, z
            // Will shift every time it updates, glLoadIdentity is required
            // to prevent traveling images
            glTranslatef(x,y,0);
            glRotatef(rot,0,0,1);
            
            glBegin(GL_QUADS);
            {
                glVertex2f(0,0);
                glVertex2f(0,height);
                glVertex2f(width,height);
                glVertex2f(width,0);                
            }
            glEnd();
            /*
            // Rotates image, first by degree, then by xyz axes
            glRotatef(45,0,0,1);
            */
        }
        glPopMatrix();
    }
}
