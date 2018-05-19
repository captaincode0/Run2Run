package com.run2run.game;

import com.run2run.main.Game;

public class GameLoop implements ContextableInterface{
    private final double REFRESH_RATE = 60.0;
    private final double NANO_SECONDS = 1000000000 / REFRESH_RATE;
    private long initialTime;
    private long lastTimeRefreshed;
    private long currentTimeRefreshed;
    private int framesPerSecond;
    private double delta;
    private Game game;

    public GameLoop(){
        initialTime = System.currentTimeMillis();
        lastTimeRefreshed = System.nanoTime();
        framesPerSecond = 0;
        delta = 0;
    }

    @Override
    public void set(Context context){
        game = (Game) context;
    }

    public void refresh(){
        for(;game.isGameRunning();){
            currentTimeRefreshed = System.nanoTime();

            delta += (currentTimeRefreshed-lastTimeRefreshed)/NANO_SECONDS;
            lastTimeRefreshed = currentTimeRefreshed;

            for(;delta>=1;delta--)
                game.getRenderizableLayer()
                        .tick();

            if(game.isGameRunning())
                game.getRenderizableLayer()
                        .render();

            ++framesPerSecond;

            if(System.currentTimeMillis() - initialTime > 1000){
                initialTime += 1000;
                System.out.println("Frames Per Second: "+framesPerSecond);
                framesPerSecond = 0;
            }
        }

        game.stop();
    }
}
