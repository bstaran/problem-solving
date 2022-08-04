package 수찾기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] NArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] MArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(NArr);
        for (int i = 0; i < M; i++) {
            boolean result = false;
            int sIdx = 0;
            int eIdx = NArr.length - 1;
            while (sIdx<=eIdx) {
                int idx = (sIdx + eIdx) / 2;
                if (NArr[idx] == MArr[i]) {
                    result = true;
                    break;
                } else if (NArr[idx] > MArr[i]) {
                    eIdx = idx - 1;
                } else {
                    sIdx = idx + 1;
                }
            }
            if (result) bw.write("1\n");
            else bw.write("0\n");
        }
        bw.flush();
        bw.close();
    }
}
