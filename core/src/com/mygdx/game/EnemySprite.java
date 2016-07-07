package com.mygdx.game;

/**
 * Created by Steven Hancock on 3/31/2016.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class EnemySprite extends Sprite{

    public EnemySprite(String name) {
        super(new Texture(Gdx.files.internal(""+name+".png")));
    }

    public void setSprite(String spriteName){
        this.setTexture(new Texture(Gdx.files.internal(""+spriteName+".png")));
    }
}
