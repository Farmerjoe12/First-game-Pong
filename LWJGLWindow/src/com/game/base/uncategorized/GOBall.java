/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

/**
 *
 * @author Adam Farmelo
 */
public class GOBall extends GameObject {
    
    public static final int SIZE = 16;
    public final float MAX_SPEEDX = 4f;
    public final float MAX_SPEEDY = 8f;
    public static final float DAMPING = 0.05f;
    
    public float velX, velY;
    public float startX, startY;
    
    public GOBall(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = SIZE;
        this.height = SIZE;
        
        this.startX = x;
        this.startY = y;
        
        this.velX = -MAX_SPEEDX;
        this.velY = 0;
    }
    
    @Override
    public void update() {
        x += velX;
        y += velY;
    }
    
    public void resetPosition() {
        x = startX;
        y = startY;
        
        // Stop any Y velocity, and reverse direction 
        // towards winning player
        velY = 0;
        velX *= -1;
    }
    
    public void reverseX(float center) {
       velX *= -1;
       velY += (getCenterY() - center) * DAMPING;
       
       if (velY > MAX_SPEEDY)
           velY = MAX_SPEEDY;
       if (velY < -MAX_SPEEDY)
           velY = -MAX_SPEEDY;
    }
    
    public void reverseY() {
        velY *= -1;
    }
}
