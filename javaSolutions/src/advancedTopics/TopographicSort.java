package advancedTopics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

public class TopographicSort {
    public static class TopographicGraph {

        // No. of vertices
        private int V;
        private HashMap<Integer, ArrayList<Integer>> adj;

        TopographicGraph(int v) {
            V = v;
            this.adj = new HashMap<>(v);
        }

        TopographicGraph(int v, HashMap<Integer, ArrayList<Integer>> adj) {
            V = v;
            this.adj = adj;
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            if (adj.containsKey(v)) {
                adj.get(v).add(w);
                addNode(w, null);
            } else {
                addNode(v, w);
                addNode(w, null);
            }
        }

        void addNode(int v, Integer w) {
            ArrayList<Integer> edge;
            if (adj.containsKey(v)) {
                edge = adj.get(v);
            } else {
                edge = new ArrayList<>();
            }

            //Add child
            if (w != null) {
                edge.add(w);
            }
            adj.put(v, edge);
        }
    }

    public static ArrayList<Integer> topologicalSort(TopographicGraph g) {
        ArrayList<Integer> result = new ArrayList();
        HashSet<Integer> visited = new HashSet<>(g.V);

        for (int k : g.adj.keySet()) {
            if (!visited.contains(k)) {
                dfsPostOrder(k, visited, result, g.adj);
            }
        }
        Collections.reverse(result);
        return result;
    }

    public static void dfsPostOrder(int k, HashSet<Integer> visited, ArrayList<Integer> result, HashMap<Integer, ArrayList<Integer>> adj) {
        Stack<Integer> s = new Stack();
        HashSet<Integer> childrenProcessed = new HashSet<>();
        s.push(k);
        while (!s.isEmpty()) {
            int current = s.pop();
            if (childrenProcessed.contains(current) && visited.contains(current)) {
                result.add(current);
            } else {
                //If we have not seen this child from a different parent
                if (!visited.contains(current)) {
                    childrenProcessed.add(current);
                    visited.add(current);

                    //this lets us come back to this node
                    // after we have visited all of its children
                    s.push(current);

                    //
                    for (int i : adj.get(current)) {
                        s.push(i);
                    }
                }
            }
        }

    }

    /**
     * Example class
     * 5       4
     * /   \  /   \
     * 2      0     |
     * \         |
     * 3      |
     * \   |
     * 1
     * <p>
     * <p>
     * 5 = {2,0}
     * 4 = {1, 0}
     * 3 = {1}
     * 2 = {3}
     * 1 = {}
     * 0 = {}
     */
    @Test
    public void test() {
        // Create a graph given in the above diagram
        TopographicGraph g = new TopographicGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        // Function Call
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(2);
        expected.add(3);
        expected.add(1);
        expected.add(0);
        ArrayList<Integer> result = topologicalSort(g);
        Assert.assertArrayEquals(expected.toArray(), result.toArray());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TopographicSort.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
