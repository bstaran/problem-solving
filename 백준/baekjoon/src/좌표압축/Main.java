package 좌표압축;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tmp = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            tmp[i] = num;
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int num : arr) {
            if (!map.containsKey(num)) {
                map.put(num, cnt);
                cnt++;
            }
        }
        for (int i = 0; i < N; i++) bw.write(map.get(tmp[i])+" ");

        bw.flush();
        bw.close();
    }
}
