package 전력망을둘로나누기;

import java.util.ArrayList;

public class Solution {

    static ArrayList<ArrayList<Integer>> graph;
    static int temp;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        for (int[] wire : wires) {

            dfs(wire[0], wire[1], new boolean[n + 1]);
            int result = temp;
            temp=0;
            dfs(wire[1], wire[0], new boolean[n + 1]);
            result-=temp;
            temp=0;

            answer = Math.min(Math.abs(result), answer);
        }

        return answer;
    }

    private void dfs(int e, int v, boolean[] visited) {
        visited[e]=true;
        temp++;

        for (int node : graph.get(e)) {
            if (!visited[node] && node!=v)
                dfs(node, v, visited);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
        System.out.println(s.solution(4, new int[][]{{1,2},{2,3},{3,4}}));
    }
}
