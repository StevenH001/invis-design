package com.mygdx.game.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.ai.pfa;

/**
 * Created by Steven Hancock on 6/16/2016.
 */
public class Node implements IndexedNode<Node> {
    //Array for storing connections of nodes, the from node and to node of each node
    private Array<Connection<Node>> connections = new Array<Connection<Node>>();
    public int type;
    public int index;

    public Node() {
        index = Indexer.getIndex();
    }

    //@Override
    public int getIndex() {
        return index;
    }

    //@Override
    public Array<Connection<Node>> getConnections() { return connections; }

    public void createConnections(Node toNode, float cost) {
        //Take this node, the connection it is going to and the cost and make a new connection
        connections.add(new ConnectionImp(this, toNode, cost));
    }

    //Contatined class for indexing each node to create our indexed pathfinder
    private static class Indexer {
        private static int index = 0;

        public static int getIndex() {
            return index++;
        }
    }

    //Type for added for creating differing costs for moving
    public static class Type {
        public static final int REGULAR = 1;
    }
}
