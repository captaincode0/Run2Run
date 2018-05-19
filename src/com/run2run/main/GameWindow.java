package com.run2run.main;

import javax.swing.JFrame;
import java.awt.*;

public class GameWindow extends Canvas{
    private int width;
    private int height;
    public final static String windowTitle = "Run2Run";

    public GameWindow(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void drawGame(Game game){
        JFrame frame = new JFrame(windowTitle);
        Dimension frameDimension = new Dimension(width, height);

        frame.setPreferredSize(frameDimension);
        frame.setMaximumSize(frameDimension);
        frame.setMinimumSize(frameDimension);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
}
