package com.run2run.game;

import com.run2run.main.Game;

public class GameThread implements Runnable, ContextableInterface{
    private Game game;
    private Thread gameThread;

    @Override
    public void set(Context game){
        this.game = (Game) game;
    }

    public synchronized void start(){
        gameThread = new Thread(this);
        gameThread.start();
        game.playGame();
    }

    public synchronized void stop() throws InterruptedException{
        gameThread.join();
        game.stopGame();
    }

    @Override
    public void run(){
        System.out.println("Running thread");
        game.getGameLoop().refresh();
    }
}
