package com.mygdx.game.pathfinding;

/**
 * Created by Steven Hancock on 7/28/2016.
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.pfa.Heuristic;
import com.mygdx.game.Map;

public class HeuristicImp implements Heuristic<Node> {
    @Override
    public float estimate(Node startNode, Node endNode) {
        int startIndex = startNode.getIndex();
        int endIndex = endNode.getIndex();

        int startY = startIndex / Map.width;
        int startX = startIndex % Map.width;

        int endY = endIndex / Map.width;
        int endX = endIndex % Map.width;

        //Calculate distance based on Pythagorean theorem
        float distance = (Math.abs(startX - endX) * Math.abs(startX - endX)) + (Math.abs(startY - endY) * Math.abs(startY - endY));

        return distance;
    }
}
