package com.run2run.main;

import com.run2run.game.Context;
import com.run2run.game.ContextableInterface;
import com.run2run.game.RenderizableInterface;
import com.sun.istack.internal.NotNull;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class RenderizableLayer implements RenderizableInterface, ContextableInterface {
    private Game game;
    private BufferStrategy bufferStrategy;
    private Graphics drawedGraphics;

    @Override
    public void set(Context context) {
        game = (Game) context;
    }

    @Override
    public void render(){
        bufferStrategy = game.getBufferStrategy();

        if(bufferStrategy == null) {
            game.createBufferStrategy(3);
            return;
        }

        drawedGraphics = bufferStrategy.getDrawGraphics();

        drawedGraphics.setColor(Color.black);
        drawedGraphics.fillRect(0, 0, game.getWidth(), game.getHeight());
        drawedGraphics.dispose();
        bufferStrategy.show();
    }

    public void tick(){
    }
}
