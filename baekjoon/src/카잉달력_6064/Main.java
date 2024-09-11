package 카잉달력_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int gcd = GCD(m, n);
            int lcm = (m * n) / gcd; // Least Common Multiple: 최소공배수

            int answer = -1;
            int year = x;
            while (year <= lcm) {
                // 마지막 해를 0으로 처리하지 않게 적용
                if ((year - 1) % n + 1 == y) {
                    answer = year;
                }
                year += m;
            }
            System.out.println(answer);
        }
    }

    // Greatest Common Divisor: 최대공약수
    static int GCD(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
