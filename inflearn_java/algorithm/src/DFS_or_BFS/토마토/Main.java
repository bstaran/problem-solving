package DFS_or_BFS.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] box;
    static int[] dx={0, 0, 1, -1};
    static int[] dy={1, -1, 0, 0};
    static int width;
    static int height;
    static Queue<Integer[]> q=new LinkedList<>();

    public static int bfs() {

        int answer=0;

        while (!q.isEmpty()){

            Integer[] tomato = q.poll();

            int x = tomato[0];
            int y = tomato[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < width && ny >= 0 && ny < height && box[ny][nx] == 0) {
                    answer = box[y][x] + 1;
                    box[ny][nx]=answer;
                    q.offer(new Integer[]{nx,ny});
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (box[i][j]==0) return -1;
            }
        }


        return answer-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        box = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < width; j++) {
                int n = Integer.parseInt(st.nextToken());
                box[i][j]= n;
                if (n==1) q.offer(new Integer[]{j, i});
            }
        }
        System.out.println(bfs());
    }
}
