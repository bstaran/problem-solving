package 숫자카드2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> cardsN = new HashMap<>();
        String[] cards = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cardsN.put(cards[i], cardsN.getOrDefault(cards[i],0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] cards2 = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            if (cardsN.containsKey(cards2[i])) bw.write(cardsN.get(cards2[i]) + " ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
