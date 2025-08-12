package 분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int pv = 0;
        int tmp = n;
        while (tmp != 0) {
            tmp /= 10;
            pv++;
        }

        int from = n - 9 * pv;
        boolean flag = false;
        for (int i = from; i <= n; i++) {
            int num = from;
            int result = from;
            while (num != 0) {
                int r = num % 10;
                num /= 10;
                result += r;
            }
            if (result == n) {
                flag = true;
                break;
            }
            from++;
        }

        if (flag)
            System.out.println(from);
        else
            System.out.println(0);
    }
}
