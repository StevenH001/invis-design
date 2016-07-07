package com.mygdx.game.pathfinding;


import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.Graph;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Map;
/**
 * Created by Steven Hancock on 6/16/2016.
 */
public abstract class GraphImp implements IndexedGraph<Node> {
    private Array<Node> nodes = new Array<Node>();

    public GraphImp() {
        super();
    }
    public GraphImp(int capacity) {
        super(capacity);
    }

    public GraphImp(Array<Node> nodes) {
        super(nodes);
        this.nodes = nodes;
    }

    @Override
    public Array<Connection<Node>> getConnection(Node fromNode) {
        return super.getConnections(fromNode);
    }


    @Override
    public int getNodeCount() {
        return super.getNodeCount();
    }

    public Node getNodeByXY(int x, int y) {
        int nodx = x / 50;
        int nodY = y / 50;
    }

}
