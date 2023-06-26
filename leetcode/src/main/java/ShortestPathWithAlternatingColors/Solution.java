package ShortestPathWithAlternatingColors;

import java.util.*;

class Solution {

    final int INF = 1_000_000_000;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        Set<Integer>[][] edgeMap = new HashSet[2][n];
        for (int i = 0; i < n; i++) {
            edgeMap[0][i] = new HashSet<>();
            edgeMap[1][i] = new HashSet<>();
        }
        // 0 - red, 1 - blue
        for (int[] redEdge : redEdges) {
            edgeMap[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            edgeMap[1][blueEdge[0]].add(blueEdge[1]);
        }

        int[][] result = new int[2][n];
        for (int i = 1; i < n; i++) {
            result[0][i] = INF;
            result[1][i] = INF;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        q.add(new int[]{0, 1});
        result[0][0] = 0;
        result[1][0] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int vert = node[0];
            int color = node[1];

            for (int to : edgeMap[1 - color][vert]) {
                if (result[1 - color][to] == INF) {
                    result[1 - color][to] = 1 + result[color][vert];
                    q.offer(new int[]{to, 1 - color});
                }
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(result[0][i], result[1][i]);
            answer[i] = (min == INF) ? -1 : min;
        }

        return answer;
    }
}