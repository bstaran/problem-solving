package 수정렬하기2;

import java.io.*;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) treeSet.add(Integer.valueOf(br.readLine()));

        int ts=treeSet.size();
        for (int i = 0; i < ts; i++) {
            bw.write(treeSet.pollFirst() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
