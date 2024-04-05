package solved.ac_18110;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);
        float trunc = (float) ((N * 0.15));
        int exclusionNumber = Math.round(trunc);

        int sum = 0;
        for (int i = exclusionNumber; i < N-exclusionNumber; i++) {
            sum += levels[i];
        }

        float level = (float) sum / (N - exclusionNumber * 2);
        int answer = Math.round(level);

        bw.write(Integer.toString(answer));
        bw.flush();

        br.close();
        bw.close();
    }
}
