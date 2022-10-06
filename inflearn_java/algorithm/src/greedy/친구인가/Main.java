package greedy.친구인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] students = new int[n + 1];

        for (int i = 1; i <= n; i++)
            students[i] = i;


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(students, a, b);
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (find(students, a, b)) System.out.println("YES");
        else System.out.println("NO");
    }
}
