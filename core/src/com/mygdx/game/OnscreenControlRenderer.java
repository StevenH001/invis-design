package com.mygdx.game;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/*
 * Created by Steven Hancock on 2/18/2016.
*/
public class OnscreenControlRenderer {
    Map map;
    SpriteBatch batch;



    public OnscreenControlRenderer (Map map) {
        this.map = map;
        loadAssets();
    }

    private void loadAssets () {
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 750, 750);
    }

    public void render () {
        //if (Gdx.app.getType() != ApplicationType.Android && Gdx.app.getType() != ApplicationType.iOS) return;
            batch.begin();
            batch.end();
    }

    public void dispose () {
        batch.dispose();
    }
}
