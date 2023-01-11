package Maze;

import Graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class JoinabilityAlgorithmMaze {

    private static Counter counter;

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

        boolean[] marked = new boolean[graph.V()];
        int[] parent = new int[graph.V()];

        counter = new Counter();
        LinkedList<Integer> workList = new LinkedList<Integer>();

        workList.addFirst(graph.source()); System.out.println("stackedNodes:\n" + ++counter.stackedNodes);
        marked[graph.source()] = true;

        while( !workList.isEmpty() ){
            counter.maxStackSize = Math.max(counter.maxStackSize, counter.stackedNodes);
            int node = workList.removeFirst(); System.out.println(--counter.stackedNodes); ++counter.totalNodesTraversed;
            if (node == graph.end())
                break;
            for(int neighbor : graph.adj(node)){
                if( !marked[neighbor] ){
                    marked[neighbor] = true;
                    parent[neighbor] = node;
                    workList.addFirst(neighbor); System.out.println(++counter.stackedNodes);
                }
            }
        }

        Stack<Integer> path = new Stack<Integer>();
        for(int node = graph.end(); node != graph.source(); node = parent[node])
            path.push(node);
        path.push(graph.source());

        System.out.println("-----");
        System.out.println("maxStackSize = " + counter.maxStackSize);
        System.out.println("totalNodesTraversed = " + counter.totalNodesTraversed);
        return path.size() - 1;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}
