package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.pathfinding.GraphImp;
import com.mygdx.game.pathfinding.Node;
import com.mygdx.game.pathfinding.GraphGenerator;


/**
 * Created by Steven Hancock on 2/18/2016.
 */
public class Map{

    public static TiledMap tileMap;
    public TiledMapTileLayer collisionLayer;
    OrthogonalTiledMapRenderer renderer;
    public static int width;
    public static int height;
    public static int mapPixelWidth;
    public static int mapPixelHeight;
    public static int tilePixelWidth;
    public static int tilePixelHeight;
    public static GraphImp graph;



        public Map() {
            //Load the map and rendere
            tileMap = new TmxMapLoader().load("Testmap.tmx");
            renderer = new OrthogonalTiledMapRenderer(tileMap);

            //Load the properties
            MapProperties properties = tileMap.getProperties();

            //Get the width and height of the map in both pixels and tiles
            width = properties.get("width",Integer.class);
            height = properties.get("height",Integer.class);
            mapPixelWidth = properties.get("tilewidth", Integer.class);
            mapPixelHeight = properties.get("tileheight", Integer.class);
            mapPixelWidth = width * tilePixelWidth;
            mapPixelHeight = height * tilePixelHeight;

            //Get the collision layer of the map
            collisionLayer = (TiledMapTileLayer)tileMap.getLayers().get("collisionLayer");

            graph = GraphGenerator.generateGraph(tileMap);
        }


    public void update (OrthographicCamera cam)
    {
        renderer.setView(cam);
        renderer.render();

    }
    public void getPathTo(int x1, int y1, int x2, int y2){

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}