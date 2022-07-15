package array.q6_뒤집은소수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public String solution(String s, int n) {

        StringTokenizer st = new StringTokenizer(s);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
            int num = Integer.parseInt(sb.toString());
            int length = (int) Math.sqrt(num);
            if (num==2 || num==3) answer.append(num).append(" ");
            for (int j = 2; j <= length; j++) {
                if (num%j==0) break;
                if (j==length) answer.append(num).append(" ");
            }
        }

        return answer.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Main main = new Main();
        bw.write(main.solution(s,N));
        bw.flush();
        bw.close();
        br.close();
    }
}
