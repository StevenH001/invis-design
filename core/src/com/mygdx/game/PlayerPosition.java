package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Steven Hancock on 3/24/2016.
 */
public class PlayerPosition extends Vector2 {


    public Vector2 oldPosition;

    public PlayerPosition() {
        this.x = 19;
        this.y = 10 + 7;

        oldPosition = new Vector2();
        oldPosition.set(this.x,this.y);
    }



}

