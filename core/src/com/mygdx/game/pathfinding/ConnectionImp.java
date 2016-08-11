package com.mygdx.game.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.GraphPath;

/**
 * Created by Steven Hancock on 6/16/2016.
 * This class just creates the connection for nodes and sets up the to, from and cost of each node.
 */
public class ConnectionImp implements Connection<Node> {
    private Node toNode;
    private Node fromNode;
    private float cost;

    //Constructor to set up to, from and cost of each created node
    public ConnectionImp(Node fromNode, Node toNode, float cost) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.cost = cost;
    }



    //Getters and Setter
    @Override
    public float getCost() {
        return cost;
    }
    @Override
    public Node getFromNode() {
        return fromNode;
    }
    @Override
    public Node getToNode() {
        return toNode;
    }

}
