package 조합_2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        br.close();

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        // n!/(n-m)!*m!

        BigInteger nf = BigInteger.ONE;
        BigInteger nmf = BigInteger.ONE;
        BigInteger mf = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            nf = nf.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = 1; i <= n-m ; i++) {
            nmf = nmf.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = 1; i <= m; i++) {
            mf = mf.multiply(new BigInteger(String.valueOf(i)));
        }

        BigInteger result = nf.divide(nmf.multiply(mf));
        System.out.println(result);
    }
}
