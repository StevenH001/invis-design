
/*******************************************************************************
 *
 ******************************************************************************/

package com.mygdx.game;

import com.mygdx.game.MainMenu;
import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
        @Override
    public void create() {
            setScreen(new MainMenu((this)));
        }
}