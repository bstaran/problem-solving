package 가장가까운세사람의심리적거리_20529;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int dist = getMinDistance(br);
            bw.write(String.valueOf(dist));
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int getMinDistance(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] MBTIs = new String[N];
        for (int i = 0; i < N; i++) {
            MBTIs[i] = st.nextToken();
        }

        // 비둘기의 집 원리 적용
        // - 비둘기가 n마리, 비둘기 집이 m개 라고 했을 때, 비둘기가 n+1마리가 되면 적어도 하나의 집에 비둘기가 2마리 들어가는 원리
        // - MBTI의 종류는 총 16가지이므로, N이 16을 초과한다면 적어도 2명은 갖은 MBTI를 가진다.
        // - 추가로 N이 32를 초과한다면 3명이 갖은 MBTI를 가진다.
        // - 즉, N이 32보다 크다면 언제나 심리적으로 가장 가까운 최소거리는 0이다.
        if (N > 32) {
            return 0;
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int dist = calculateDistance(MBTIs[i], MBTIs[j]) +
                            calculateDistance(MBTIs[i], MBTIs[k]) +
                            calculateDistance(MBTIs[j], MBTIs[k]);

                    minDistance = Math.min(minDistance, dist);
                }
            }
        }

        return minDistance;
    }

    private static int calculateDistance(String mbti1, String mbti2) {

        int dist = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1.equals(mbti2)) {
                return 0;
            }
            if (mbti1.charAt(i) != mbti2.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}
