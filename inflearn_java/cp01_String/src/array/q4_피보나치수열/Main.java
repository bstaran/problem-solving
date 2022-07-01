package array.q4_피보나치수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(int n) {
        String answer = "1 1";

        int sum = 2;
        for (int i = 0; i < n-3; i++) {
            sum = ((int)answer.charAt(answer.length() - 1)) + sum;
            answer+=sum;
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());

        System.out.println(main.solution(n));
    }
}
