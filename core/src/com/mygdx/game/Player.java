package com.mygdx.game;

import java.io.IOException;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;


/**
 * Created by Steven Hancock on 2/14/2016.
 */


public class Player {
    public PlayerSprite playerSprite;
    public PlayerPosition playerPosition;
    public PlayerInput playerInput;
    public PlayerMovement playerMovement;


    public float tileSize = 32f;

    public Player() {
        playerSprite = new PlayerSprite();
        playerPosition = new PlayerPosition();
        playerInput = new PlayerInput();
        playerMovement = new PlayerMovement();

    }

    public void update(GameScreen gs){
        playerMovement.moveDirection = playerInput.update(gs);
        playerMovement.update();
    }

    public void load(){

        XmlReader reader = new XmlReader();
        Element root = null;
        try {
            root = reader.parse(Gdx.files.internal("player.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //LOAD POSITION
        Element position = root.getChildByName("position");
        //int defaultX = 19, defaultY = 17;
        int x = position.getIntAttribute("x");
        int y = position.getIntAttribute("y");
        //int offsetX = x-defaultX;
        //int offsetY = y-defaultY;
        //GameScreen.camera.translate(offsetX*32,offsetY*32);
        playerPosition.set(x, y);

    }


    public void save(){

    }
}
