package 숫자카드;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> cardsN = new LinkedHashSet<>();
        String[] cards = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cardsN.add(cards[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] cards2 = br.readLine().split(" ");
        HashSet<String> cardsM = new LinkedHashSet<>();
        for (int i = 0; i < M; i++) {
            cardsM.add(cards2[i]);
        }

        for (String s : cardsM) {
            if (cardsN.contains(s)) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
