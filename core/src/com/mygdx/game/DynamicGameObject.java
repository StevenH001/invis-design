package com.mygdx.game;

/**
 * Created by Steven Hancock on 2/25/2016.
 * This class is designed to add additional attributes to the game object class. It allows for the creation of dynamic objects that
 * have velocity and acceleration.
 */
import com.badlogic.gdx.math.Vector2;

public class DynamicGameObject extends GameObject {
    //Define vectors for velocity and acceleration of game objects
    public final Vector2 velocity;
    public final Vector2 accel;
    
    //Constructor for dynamic game objects
    public DynamicGameObject (float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2();
        accel = new Vector2();
    }
}
