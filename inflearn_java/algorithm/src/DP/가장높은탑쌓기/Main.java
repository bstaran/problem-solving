package DP.가장높은탑쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Brick> bricks = new ArrayList<>();
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            bricks.add(new Brick(e,h,w));
        }

        Collections.sort(bricks);

        dy[0] = bricks.get(0).height;
//        int answer=dy[0];
        int answer=0;

        for (int i = 1; i < n; i++) {
            int max=0;
            for (int j = i-1; j >= 0; j--) {
                Brick brickI = bricks.get(i);
                Brick brickJ = bricks.get(j);
                if (brickI.weight < brickJ.weight && dy[j]>max) {
                    max = dy[j];
                }
            }
            dy[i] = max+bricks.get(i).height;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}

class Brick implements Comparable<Brick> {
    int extent;
    int height;
    int weight;

    public Brick(int extent, int height, int weight) {
        this.extent = extent;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.extent - this.extent;
    }
}