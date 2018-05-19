package com.run2run.main;

import com.run2run.game.Context;
import com.run2run.game.GameLoop;
import com.run2run.game.GameThread;
import com.run2run.game.PlayableInterface;
import java.awt.Canvas;

public class Game extends Canvas implements PlayableInterface, Context {
    public final static int WIDTH = 640;
    public final static int HEIGHT = 480;

    private GameWindow gameWindow;
    private GameThread gameThread;
    private GameLoop gameLoop;
    private RenderizableLayer renderizableLayer;

    private boolean isGameRunning = false;

    public Game(){
        gameWindow = new GameWindow(WIDTH, HEIGHT);
        gameWindow.drawGame(this);

        gameLoop = new GameLoop();
        gameLoop.set(this);

        renderizableLayer = new RenderizableLayer();
        renderizableLayer.set(this);
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public RenderizableLayer getRenderizableLayer(){
        return renderizableLayer;
    }

    public GameLoop getGameLoop(){
        return gameLoop;
    }

    public boolean isGameRunning(){
        return isGameRunning;
    }

    public void stopGame(){
        isGameRunning = false;
    }

    public void playGame(){
        isGameRunning = true;
    }

    @Override
    public synchronized void start() {
        gameThread = new GameThread();
        gameThread.set(this);
        gameThread.start();
    }

    @Override
    public synchronized void stop(){
        try {
            gameThread.stop();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
