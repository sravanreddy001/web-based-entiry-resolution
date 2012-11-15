/**
 * 
 */
package edu.buffalo.cse.di.util.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import edu.buffalo.cse.di.util.entity.Node;

/**
 * @author sravanku@buffalo.edu
 */
public class KNNAlgorithm {
    
    private class NodeDistance {
        int nodeId;
        double distance;
    }
    
    List<Node> nodes = new ArrayList<Node>();
    
    Map<Node, PriorityQueue<NodeDistance>> nearestNeighbors 
            = new HashMap<Node, PriorityQueue<NodeDistance>>();
    
    public KNNAlgorithm(List<Node> nodes) {
        this.nodes = nodes;
    }
    
    
}
