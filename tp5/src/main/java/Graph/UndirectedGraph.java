package Graph;

import Maze.Tile;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;

/***
 * Graphe permettant la résolution des labyrinthes par les différents algorithmes
 */
public class UndirectedGraph implements Graph {

    private HashSet<Integer>[] neighbors;
    private int V, E;
    private int source, end;

    /***
     * Construit le graphe en numérotant les positions des lignes et des colonnes
     * et en créant les arêtes des tuiles "Floor" adjacentes
     * @param maze labyrinthe de taille M x N
     */
    public UndirectedGraph(ArrayList<ArrayList<Tile>> maze) {
        initialize(maze.size() * maze.get(0).size());

        source = -1;
        end = -1;

        for (int i = 0; i < maze.size(); i++){
            for (int j = 0; j < maze.get(i).size(); j++){
                if (maze.get(i).get(j) != Tile.Wall){
                    if (i - 1 >= 0 && maze.get(i - 1).get(j) != Tile.Wall)
                        connect(maze.get(i).size() * i + j, maze.get(i).size() * (i - 1) + j);
                    if (i + 1 < maze.size() && maze.get(i + 1).get(j) != Tile.Wall)
                        connect(maze.get(i).size() * i + j, maze.get(i).size() * (i + 1) + j);
                    if (j - 1 >= 0 && maze.get(i).get(j - 1) != Tile.Wall)
                        connect(maze.get(i).size() * i + j, maze.get(i).size() * i + j - 1);
                    if (j + 1 < maze.get(i).size() && maze.get(i).get(j + 1) != Tile.Wall)
                        connect(maze.get(i).size() * i + j, maze.get(i).size() * i + j + 1);

                    if (maze.get(i).get(j) == Tile.Exit){
                        if (source == -1)
                            source = maze.get(i).size() * i + j;
                        else
                            end = maze.get(i).size() * i + j;
                    }
                }
            }
        }
    }

    /***
     * Alloue les HashSets pour l'adjacence
     * @param V nombre de sommets
     */
    public void initialize(int V) {
        if (V < 0) throw new InvalidParameterException();
        E = 0;
        this.V = V;
        neighbors = new HashSet[V];
        for (int v = 0; v < V; v++)
            neighbors[v] = new HashSet<Integer>();
    }

    /***
     * Getter
     * @return nombre de sommets du graphe
     */
    public int V() {
        return V;
    }

    /***
     * Getter
     * @return nombre d'arêtes du graphe
     */
    public int E() {
        return E;
    }

    /***
     * Getter
     * @return entrée du labyrinthe
     */
    public int source() {
        return source;
    }

    /***
     * Getter
     * @return sortie du labyrinthe
     */
    public int end() {
        return end;
    }

    /***
     * Crée les arêtes du graphe
     * @param v1 premier sommet
     * @param v2 second sommet
     */
    public void connect(int v1, int v2) {
        if (v1 < 0 || v1 >= V) return;
        if (v2 < 0 || v2 >= V) return;
        if (neighbors[v1].contains(v2)) return;
        neighbors[v1].add(v2);
        neighbors[v2].add(v1);
        E++;
    }

    /***
     * Permet l'accès aux tuiles adjacentes
     * @param v Tuile du labyrinthe
     * @return Hashset des voisins
     */
    public HashSet<Integer> adj(int v){
        if(v<0 || v>=V) return null;
        return neighbors[v];
    }

    /***
     * Permet l'affichage du graphe
     * @return string du graphe
     */
    public String toString(){
        StringBuilder o = new StringBuilder();
        String ln = System.getProperty("line.separator");
        o.append(V + ln + E + ln);
        for(int v=0; v<V; v++)
            for(int w : neighbors[v])
                o.append(v + "-" + w + ln);
        return o.toString();
    }
}
