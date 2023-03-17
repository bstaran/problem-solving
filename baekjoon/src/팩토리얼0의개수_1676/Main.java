package 팩토리얼0의개수_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int n = N / 5;
        int n2 = N / 25;
        int n3 = N / 125;

        System.out.println(n + n2 + n3);
    }
}
