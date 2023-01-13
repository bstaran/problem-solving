package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int r = 31;
        int m = 1234567891;

        long val = 0L;
        long start = 1L;
        for (int i = 0; i < n; i++) {
            val += (s.charAt(i) - 96) * start;
            start = start * r % m;
        }

        long answer = val % m;
        System.out.println(answer);
    }
}
