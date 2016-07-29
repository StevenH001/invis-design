package com.mygdx.game.pathfinding;


import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.Graph;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Map;
/**
 * Created by Steven Hancock on 6/16/2016.
 */
public class GraphImp implements IndexedGraph<Node> {
    //Create array of nodes
    private Array<Node> nodes = new Array<Node>();

    private int capacity, NodeCount;


    public GraphImp() {
        super();
    }
    public GraphImp(int capacity) {
        this.capacity = capacity;
    }

    public GraphImp(Array<Node> nodes) {
        this.nodes = nodes;
    }

    public Array<Connection<Node>> getConnection(Node fromNode) {
        return getConnections(fromNode);
    }

    @Override
    public int getIndex(Node node) {
        //This should return the unique node index
        return 0;
    }

    @Override
    public int getNodeCount() {
        //Node count is not being updated
        return NodeCount;
    }


    //Return a node from graph based on position
    public Node getNodeByXY(int x, int y) {

        //Take pixel position and convert it to tile position
        int modX = x / Map.tilePixelWidth;
        int modY = y / Map.tilePixelHeight;

        //Return the node at that position
        return nodes.get(Map.width * modY + modX);
    }

    @Override
    public Array<Connection<Node>> getConnections(Node fromNode) {
        return null;
    }
}
