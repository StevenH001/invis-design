package com.mygdx.game.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Steven Hancock on 6/16/2016.
 */
public class Node {
    //Array for storing connections of nodes, the from node and to node of each node
    private Array<Connection<Node>> connections = new Array<Connection<Node>>();
    public int type;
    public int index;

    public int getIndex() {
        return index;
    }

    //@Override
    public Array<Connection<Node>> getConnections() { return connections; }

    public void createConnection(Node toNode, float cost) {
        connections.add(new ConnectionImp(this, toNode, cost));
    }

    //Type for added for creating differing costs for moving
    public static class Type {
        public static final int REGULAR = 1;
    }
}
