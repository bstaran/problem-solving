package 좌표정렬하기;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) arr[i] = br.readLine();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");

//                if (Integer.parseInt(s1[0]) > Integer.parseInt(s2[0])) {
//                    return 1;
//                } else if (Integer.parseInt(s1[0]) == Integer.parseInt(s2[0])) {
//                    return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
//                }
                if (Integer.parseInt(s1[0]) == Integer.parseInt(s2[0])) {
                    return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
                } else {
                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
                }
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
