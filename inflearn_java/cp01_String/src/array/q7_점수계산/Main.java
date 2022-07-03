package array.q7_점수계산;

import java.io.*;

public class Main {
    public int solution(String s, int n) {
        String[] strings = s.split(" ");
        int count = 0, answer = 0;
        for (int i = 0; i < n; i++) {
            if (strings[i].equals("1")) {
                count++;
                answer += count;
            } else count = 0;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Main main = new Main();
        bw.write(String.valueOf(main.solution(s, N)));
        bw.flush();
        bw.close();
        br.close();
    }
}
