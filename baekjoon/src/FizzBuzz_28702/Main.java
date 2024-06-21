package FizzBuzz_28702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        String str = getNextString(s1, s2, s3);
        System.out.println(str);
    }

    private static String getNextString(String s1, String s2, String s3) {

        int num = 0;
        if (isNumber(s1)) {
            num = Integer.parseInt(s1) + 3;
        } else if (isNumber(s2)) {
            num = Integer.parseInt(s2) + 2;
        } else {
            num = Integer.parseInt(s3) + 1;
        }

        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz_28702";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }

    private static boolean isNumber(String str) {
        return !str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz_28702");
    }
}
