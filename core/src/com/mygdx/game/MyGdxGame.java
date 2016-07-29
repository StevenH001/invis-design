
/*******************************************************************************
 *Created by Steven Hancock
 ******************************************************************************/

package com.mygdx.game;
//Import the hidden game class and the new main menu class
import com.mygdx.game.MainMenu;
import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
        @Override
    public void create() {
            //Set the new screen to be the main menu for the game
            setScreen(new MainMenu((this)));
        }
}
