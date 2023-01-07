package 문자열반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String ch = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ch.length(); j++) {
                sb.append(String.valueOf(ch.charAt(j)).repeat(Math.max(0, R)));
            }
            System.out.println(sb);
        }
    }
}
