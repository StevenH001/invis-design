package com.mygdx.game.pathfinding;

/**
 * Created by Steven Hancock on 7/28/2016.
 * This class holds the data passed from the graph to the pathfinder
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class GraphPathImp implements GraphPath<Node> {
    private Array<Node> nodes = new Array<Node>();

    public GraphPathImp(){

    }

    //Return the iterator
    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }
    //Return the count
    @Override
    public int getCount() {
        return nodes.size;
    }
    //Return an index
    @Override
    public Node get(int i) {
        return nodes.get(i);
    }

    public Node removeIndex(int index) {
        return nodes.removeIndex(index);
    }
    //Return a node to add
    @Override
    public void add(Node node) {
        nodes.add(node);
    }
    //Return a node to clear
    @Override
    public void clear() {
        nodes.clear();
    }
    //Return the reverse
    @Override
    public void reverse() {
        nodes.reverse();
    }
}
