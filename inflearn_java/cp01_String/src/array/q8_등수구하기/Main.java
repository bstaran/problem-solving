package array.q8_등수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public String solution(int n, String s) {
        StringTokenizer str = new StringTokenizer(s);
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(str.nextToken());
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count=1;
            for (int j = 0; j < n; j++) {
                if (score[i]<score[j]) count++;
            }
            answer.append(count).append(" ");
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Main main = new Main();

        System.out.println(main.solution(n,s));
    }
}
