package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by Steven Hancock on 2/18/2016.
 */
public abstract class InvisimanScreen implements Screen {
    Game game;

    public InvisimanScreen(Game game) {
        this.game = game;
    }


    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void show () {
    }

    @Override
    public void hide () {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose () {
    }
}

