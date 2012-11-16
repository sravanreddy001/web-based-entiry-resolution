/**
 * 
 */
package edu.buffalo.cse.di.util.entity;

/**
 * Node for the KNN Algorithm
 * @author sravanku@buffalo.edu
 */
public class Node {
    private final String string;

    public Node(String string) {
        this.string = string;
    }
    
    public String getString() {
        return string;
    }
}
