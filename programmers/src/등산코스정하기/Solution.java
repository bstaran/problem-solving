package 등산코스정하기;

import java.util.*;

public class Solution {

    List<List<Node>> graph = new ArrayList<>();
    PriorityQueue<Node> pq;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {

            // 출입구일 경우, 산봉우리일 경우
            if (isGate(path[0], gates) || isSummit(path[1], summits)) {
                graph.get(path[0]).add(new Node(path[1], path[2]));
            } else if (isGate(path[1], gates) || isSummit(path[0], summits)) {
                graph.get(path[1]).add(new Node(path[0], path[2]));
            } else {
                graph.get(path[0]).add(new Node(path[1], path[2]));
                graph.get(path[1]).add(new Node(path[0], path[2]));
            }
        }

        pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.distance)));

        int[] dijkstra = dijkstra(n, gates);

        Arrays.sort(summits);

        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int summit : summits) {
            if (dijkstra[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = dijkstra[summit];
            }
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private boolean isSummit(int summit, int[] summits) {
        for (int s : summits) {
            if (summit == s) {
                return true;
            }
        }
        return false;
    }

    private boolean isGate(int gate, int[] gates) {
        for (int g : gates) {
            if (gate == g) {
                return true;
            }
        }

        return false;
    }

    public int[] dijkstra(int n, int[] gates) {

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            d[gate] = 0;
        }

        while (!pq.isEmpty()) {

            Node poll = pq.poll();

            int now = poll.index;
            int dist = poll.distance;

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                Node node = graph.get(now).get(i);
                int cost = Math.max(d[now], node.distance);
                if (cost < d[node.index]) {
                    d[node.index] = cost;
                    pq.add(new Node(node.index, cost));
                }
            }
        }

        return d;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[][]{{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}}, new int[]{1, 2}, new int[]{5});
        solution.solution(7, new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}}, new int[]{3, 7}, new int[]{1, 5});
    }
}

class Node {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
