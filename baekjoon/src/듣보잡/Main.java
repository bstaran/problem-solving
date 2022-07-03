package 듣보잡;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        Set<String> d = new HashSet<>();
        for (int i = 0; i < N; i++) {
            d.add(br.readLine());
        }
//        List<String> answer = new ArrayList<>();
        Set<String> answer = new TreeSet<>();
        for (int i = 0; i < M; i++) {
            String val = br.readLine();
            if (d.contains(val)) answer.add(val);
        }
//        Collections.sort(answer);
        bw.write(answer.size()+"\n");
        for(String a : answer) bw.write(a+"\n");

        bw.flush();
        bw.close();
        br.close();

    }
}
