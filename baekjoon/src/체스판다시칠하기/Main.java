package 체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] black = {
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                };
        String[] white = {
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
                "WBWBWBWB",
                "BWBWBWBW",
        };

        char[][] arr = new char[M][N];
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j]=s.charAt(j);
            }
        }

        int count=0, count2=0, answer=Integer.MAX_VALUE;
        for (int i = 0; i < M-7; i++) {
            for (int j = 0; j < N-7; j++) {
                count=0;
                count2=0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (black[k].charAt(l) != arr[k+i][l+j]) count++;
                        if (white[k].charAt(l) != arr[k+i][l+j]) count2++;
                    }
                }
                answer = Math.min(answer, Math.min(count, count2));
            }
        }
        System.out.println(answer);
    }
}
