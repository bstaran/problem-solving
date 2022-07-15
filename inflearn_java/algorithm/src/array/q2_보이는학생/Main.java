package array.q2_보이는학생;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(int n, String s) {
        String[] strings = s.split(" ");
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = Integer.parseInt(strings[i]);
        int check = p[0];
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (check < p[i]) {
                check = p[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(main.solution(n, s));
    }
}
