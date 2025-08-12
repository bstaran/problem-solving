package 소수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public boolean solution(int n) {
        if (n == 1) return false;

        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n%j==0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Main main = new Main();
        int answer=0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (main.solution(n)) answer++;
        }
        System.out.println(answer);
    }
}
