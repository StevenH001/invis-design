package com.mygdx.game.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Steven Hancock on 6/16/2016.
 */
public abstract class Node implements IndexedGraph<Node> {
    private Array<Connection<Node>> connections = new Array<Connection<Node>>();
    public int type;
    public int inced;

    public Node() {
        index = Node.Indexer.getIndex();
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public Array<Connection<Node>> getConnections() { return connections; }

    public void createConnections(Node toNode, float cost) { connections.add(new ConnectionImp(this, toNode, cost)); }

    private static class Indexer {
        private static int index = 0;

        public static int getIndex() {
            return index++;
        }
    }

    public static class Type {
        public static final int REGULAR = 1;
    }
}
