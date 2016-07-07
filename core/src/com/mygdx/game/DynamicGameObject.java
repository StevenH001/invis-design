package com.mygdx.game;

/**
 * Created by Steven Hancock on 2/25/2016.
 */
import com.badlogic.gdx.math.Vector2;

public class DynamicGameObject extends GameObject {
    public final Vector2 velocity;
    public final Vector2 accel;

    public DynamicGameObject (float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2();
        accel = new Vector2();
    }
}
