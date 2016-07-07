/**
 * Created by Steven Hancock on 3/24/2016.
 */

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerSprite extends Sprite {

    private static String path = "Player.png";



    public PlayerSprite() {
        super(new Texture(Gdx.files.internal(path)));
    }
}
