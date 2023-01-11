package Maze;

import Graph.UndirectedGraph;

import java.util.*;
import java.util.stream.Collectors;


/**
 ** Implement DFS algorithm to solve the maze.
 */
public class DFSMaze {

    private static Counter counter;
    private static boolean[] marked;
    private static int[] parent;

    /**
     * Returns the distance of the path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> maze) {

        if (maze.isEmpty())
            return null;

        UndirectedGraph graph = new UndirectedGraph(maze);

        if (graph.source() == -1 || graph.end() == -1)
            return null;

        marked = new boolean[graph.V()];
        parent = new int[graph.V()];

        counter = new Counter();
        System.out.println("stackedNodes:\n" + ++counter.stackedNodes);
        dfs(graph, graph.source());

        Stack<Integer> path = new Stack<Integer>();
        for(int node = graph.end(); node != graph.source(); node = parent[node])
            path.push(node);
        path.push(graph.source());

        System.out.println("-----");
        System.out.println("maxStackSize = " + counter.maxStackSize);
        System.out.println("totalNodesTraversed = " + counter.totalNodesTraversed);
        return path.size() - 1;
    }

    /***
     * Recursive algorithm for depth first traversal
     * @param graph graph
     * @param node current node
     */
    private static boolean dfs(UndirectedGraph graph, int node){
        counter.maxStackSize = Math.max(counter.maxStackSize, counter.stackedNodes);
        marked[node] = true;
        if (node == graph.end())
            return true;
        for(int neighbor : graph.adj(node)) {
            if (!marked[neighbor]) {
                System.out.println(++counter.stackedNodes); ++counter.totalNodesTraversed;
                parent[neighbor] = node;
                if (dfs(graph, neighbor))
                    return true;
            }
        }
        System.out.println(--counter.stackedNodes);
        return false;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}

