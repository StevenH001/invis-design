package com.mygdx.game.pathfinding;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Map;



/**
 * Created by Steven Hancock on 6/16/2016.
 */
public class GraphGenerator {

    public static GraphImp generateGraph(TiledMap map)
    {
        //Create an array of all the nodes
        Array<Node> nodes = new Array<Node>();
        //Get the collision layer of the tiled map
        TiledMapTileLayer tiles = (TiledMapTileLayer)map.getLayers().get(0);
        //Set up the map height and map pixel width
        int mapHeight = Map.height;
        int mapWidth = Map.mapPixelWidth;

        //Loop over the tiles in the map from the bottom left corner
        // left to right, then bottom to top
        for (int y = 0; y < mapHeight; y++){
            for (int x = 0; x < mapWidth; x++) {
                //create a node for each tile for when we create connections
                Node node = new Node();
                node.type = Node.Type.REGULAR;
                nodes.add(node);
            }
        }

        //Loop through width and height of the tiles again (make this more efficient?)
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                //Get the nodes of each tile, the current node and the nodes to the left, right, up and down of that node
                TiledMapTileLayer.Cell target = tiles.getCell(x, y);
                TiledMapTileLayer.Cell up = tiles.getCell(x, y + 1);
                TiledMapTileLayer.Cell left = tiles.getCell(x - 1, y);
                TiledMapTileLayer.Cell right = tiles.getCell(x + 1, y);
                TiledMapTileLayer.Cell down = tiles.getCell(x, y - 1);

                //Check if the tile target is null
                Node targetNode = nodes.get(mapWidth * y + x);
                if (target == null) {
                    if (y != 0 && down == null) {
                        Node downNode = nodes.get(mapWidth * (y - 1) + x);
                        targetNode.createConnection(downNode, 1);
                    }
                    if (x != 0 && left == null) {
                        Node leftNode = nodes.get(mapWidth * y + x -1);
                        targetNode.createConnection(leftNode, 1);
                    }
                    if (x != mapWidth - 1 && right == null) {
                        Node rightNode = nodes.get(mapWidth * y + x + 1);
                        targetNode.createConnection(rightNode, 1);
                    }
                    if (y != mapHeight -1 && up == null) {
                        Node upNode = nodes.get(mapWidth * (y + 1) + x);
                        targetNode.createConnection(upNode, 1);
                    }
                }

            }

            return new GraphImp(nodes);
        }

    }
}
