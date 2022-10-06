package greedy.disjointSet;

public class Main {
    public static void union(int[] nodes, int a, int b) {
        a = find(nodes, a);
        b = find(nodes, b);

//        // root 최소값
//        if (a > b) nodes[a] = b;
//        else nodes[b] = a;
        if (a!=b) nodes[a]=b;
    }

    public static int find(int[] nodes, int node) {
        if (nodes[node] != node) nodes[node] = find(nodes, nodes[node]);

        return nodes[node];
    }

    public static boolean find(int[] nodes, int a, int b) {
        a = find(nodes, a);
        b = find(nodes, b);
        return a == b;
    }

    public static void main(String[] args) {
        int[] nodes = new int[7];

        for (int i = 1; i <= 6; i++)
            nodes[i] = i;

        union(nodes, 1, 2);
        union(nodes, 2, 3);
        union(nodes, 3, 4);
        union(nodes, 5, 6);
        System.out.println("node 6의 부모 원소 : " + find(nodes, 6));
        System.out.printf("%s와 %s는 같은 부모 원소를 가졌는가? : ", 3, 4);
        System.out.println(find(nodes, 3, 4));
    }
}
