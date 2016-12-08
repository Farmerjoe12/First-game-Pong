/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.base.uncategorized;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

/**
 * @author FreeYourMindGamer
 */
public class Game {
    
    private ArrayList<GameObject> objects;
    private GOPlayer player;
    private int playerScore;
    private int enemyScore;
    private GOBall ball;
    
    public Game() {
        objects = new ArrayList<GameObject>();
        
        playerScore = 0;
        enemyScore = 0;
        
        ball = new GOBall(Display.getWidth()/2 - GOBall.SIZE/2, 
                Display.getHeight()/2 - GOBall.SIZE/2);
        
        player = new GOPlayer(0,Display.getHeight()/2-GOPlayer.SIZEY/2,ball);
        
        GOEnemy enemy = new GOEnemy(Display.getWidth()-GOEnemy.SIZEX,
                Display.getHeight()/2-GOPlayer.SIZEY/2,ball);
        
        GOWall wall1 = new GOWall(0,0,Display.getWidth(), GOWall.STDSIZE,ball);
        GOWall wall2 = new GOWall(0,Display.getHeight()-GOWall.STDSIZE
                ,Display.getWidth(), GOWall.STDSIZE,ball);
        
        objects.add(ball);
        objects.add(player);
        objects.add(enemy);
        objects.add(wall1);
        objects.add(wall2);

    }
    
    public void getInput() {
        if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            player.move(1);
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            player.move(-1);
        }
    }
    
    public void update() {
        for(GameObject go:objects)
            go.update();
        
        if (ball.getX() > Display.getWidth()) {
            playerScore++;
            ball.resetPosition();
        }
        
        if (ball.getX() < 0) {
            enemyScore++;
            ball.resetPosition();
        }
    }
    
    public void render() {
        for(GameObject go:objects)
            go.render();
        
        Display.setTitle("Score: P " + playerScore + 
                ". Score: E " + enemyScore + ".");
    }
}
