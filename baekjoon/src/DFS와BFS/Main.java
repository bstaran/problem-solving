package DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);

        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (!visited[poll]) {
                visited[poll] = true;
                System.out.print(poll + " ");
                ArrayList<Integer> list = graph.get(poll);
                Collections.sort(list);
                for (Integer integer : list) {
                    if (!visited[integer]) {
                        queue.add(integer);
                    }
                }
            }
        }
    }

    private static void dfs(int start) {

        if (!visited[start]) {
            System.out.print(start + " ");
            visited[start] = true;
            ArrayList<Integer> list = graph.get(start);
            Collections.sort(list);
            for (Integer integer : list) {
                if (!visited[integer]) {
                    dfs(integer);
                }
            }
        }
    }
}
