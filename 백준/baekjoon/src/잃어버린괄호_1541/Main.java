package 잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        boolean flag = false;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            String[] split = str.split("\\+");

            if (flag) {
                for (String s : split) {
                    answer -= Integer.parseInt(s);
                }
            } else {
                for (String s : split) {
                    answer += Integer.parseInt(s);
                }
            }

            flag = true;
        }

        br.close();

        System.out.println(answer);
    }
}
