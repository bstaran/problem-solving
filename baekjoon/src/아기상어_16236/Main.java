package 아기상어_16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[][] map;
    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, -1, 0, 1};
    private static int N;
    private static int fishStack;
    private static int answer;
    private static int sharkSize;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int nx = 0, ny = 0;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (str[j].equals("9")) {
                    nx = j;
                    ny = i;
                }
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        br.close();

        sharkSize = 2;

        bfs(nx, ny, sharkSize);

        System.out.println(answer);
    }
    private static void bfs(int nx, int ny, int size) {

        while (true) {

            Queue<Fish> q = new LinkedList<>();
            Fish nextFish = new Fish(nx, ny, Integer.MAX_VALUE);
            boolean[][] visit = new boolean[N][N];
            visit[ny][nx] = true;
            map[ny][nx] = 0;
            q.add(new Fish(nx, ny, 0));

            while (!q.isEmpty()) {

                Fish fish = q.poll();

                for (int i = 0; i < 4; i++) {
                    int dx = fish.x + X[i];
                    int dy = fish.y + Y[i];

                    // 배열 범위 설정 + 물고기의 크기가 size 보다 큰 경우 제외
                    if (dx < 0 || dy < 0 || dx >= N || dy >= N || visit[dy][dx]) {
                        continue;
                    }

                    // 먹을 수 있는 물고기가 있다면 리스트에 추가
                    if (map[dy][dx] > 0 && map[dy][dx] < size) {
                        visit[dy][dx] = true;
                        q.add(new Fish(dx, dy, fish.dist + 1));

                        if (nextFish.dist > fish.dist + 1) {
                            nextFish = new Fish(dx, dy, fish.dist + 1);
                        } else if (nextFish.dist == fish.dist + 1) {
                            if (nextFish.y > dy) {
                                nextFish = new Fish(dx, dy, fish.dist + 1);
                            } else if (nextFish.y == dy) {
                                if (nextFish.x> dx) {
                                    nextFish = new Fish(dx, dy, fish.dist + 1);
                                }
                            }
                        }

                    } else if (map[dy][dx] == 0 || map[dy][dx] == size) {
                        visit[dy][dx] = true;
                        q.add(new Fish(dx, dy, fish.dist + 1));
                    }
                }
            }
            if (nextFish.dist == Integer.MAX_VALUE) {
                break;
            }
            answer += nextFish.dist;

            fishStack++;
            if (sharkSize == fishStack) {
                sharkSize++;
                fishStack = 0;
            }
            nx = nextFish.x;
            ny = nextFish.y;
            size = sharkSize;
        }
    }
    static class Fish {
        int x;
        int y;
        int dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
