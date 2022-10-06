package greedy.다익스트라알고리즘;

public class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
