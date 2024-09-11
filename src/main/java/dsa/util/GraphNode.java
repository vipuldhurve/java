package dsa.util;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        if(this == null) return "null";
        return "GraphNode" + "@" + Integer.toHexString(hashCode()) + "{ " +
                "val=" + val +
                ", neighbors=[" + neighborsToString() +
                "] }";
    }

    private String neighborsToString() {
        if(this==null) return "";
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < neighbors.size(); i++) {
            if (i == neighbors.size() - 1) s.append(neighbors.get(i).val);
            else s.append(neighbors.get(i).val + ",");
        }
        return s.toString();
    }
}