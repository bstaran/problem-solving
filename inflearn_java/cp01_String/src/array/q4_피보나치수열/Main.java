package array.q4_피보나치수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder("1 1 2");

        int num1 = 2;
        int num2 = 1;
        for (int i = 0; i < n-3; i++) {
            int sum = num1 + num2;
            answer.append(" " + sum);
            int temp = num1;
            num1 = sum;
            num2 = temp;
        }
        
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();

        int n = Integer.parseInt(br.readLine());

        System.out.println(main.solution(n));
    }
}
