package 미로탈출;

import java.util.*;

class Solution {

    int[][] visited;
    int answer;
    int[] lever = new int[2];
    int[] start = new int[2];
    int[] exit = new int[2];
    int[] X = {-1, 0, 1, 0};
    int[] Y = {0, -1, 0, 1};

    public int solution(String[] maps) {

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char word = maps[i].charAt(j);
                if (word == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (word == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (word == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }

        int startToLever = bfs(maps, start, lever);
        if (startToLever == 0) return -1;
        int leverToExit = bfs(maps, lever, exit);
        if (leverToExit == 0) return -1;

        return startToLever + leverToExit;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        visited = new int[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();

        q.offer(start);
        visited[start[0]][start[1]] = 0;
        char targetWord = maps[target[0]].charAt(target[1]);
        while (!q.isEmpty()) {

            int[] p = q.poll();
            char word = maps[p[0]].charAt(p[1]);

            if (word == targetWord) {
                return visited[p[0]][p[1]];
            }

            for (int i = 0; i < 4; i++) {

                int x = X[i] + p[1];
                int y = Y[i] + p[0];

                if (x < 0 || x >= maps[0].length() ||
                        y < 0 || y >= maps.length) {
                    continue;
                }

                char nextWord = maps[y].charAt(x);

                if (nextWord != 'X' && visited[y][x] == 0) {
                    visited[y][x] = visited[p[0]][p[1]] + 1;
                    q.offer(new int[]{y, x});
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
//        System.out.println(s.solution(new String[]{"SXXOX", "EXXXL", "OOXOO", "OXXXX", "OOOOO"}));
//        System.out.println(s.solution(new String[]{"SELOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));
        System.out.println(s.solution(new String[]{"SLEOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"}));
    }
}