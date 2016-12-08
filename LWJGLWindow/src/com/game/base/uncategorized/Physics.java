/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import java.awt.Rectangle;

/**
 *
 * @author Adam Farmelo
 */
public class Physics {
    private static int go1X, go1Y, go1Width, go1Height;
    private static int go2X, go2Y, go2Width, go2Height;
    
    public Physics() {
    }
    
    public static boolean checkCollisions(GameObject go1, GameObject go2) {
        
        go1X = (int) go1.getX();
        go1Y = (int) go1.getY();
        go1Width = (int) go1.getWidth();
        go1Height = (int) go1.getHeight();
        
        go2X = (int) go2.getX();
        go2Y = (int) go2.getY();
        go2Width = (int) go2.getWidth();
        go2Height = (int) go2.getHeight();
        Rectangle r1 = new Rectangle(go1X, go1Y, 
                go1Width, go1Height);
        
        Rectangle r2 = new Rectangle(go2X, go2Y, 
                go2Width, go2Height);
        
        return r1.intersects(r2);
    }
}
