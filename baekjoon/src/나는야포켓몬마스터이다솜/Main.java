package 나는야포켓몬마스터이다솜;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] length = br.readLine().split(" ");
        int book = Integer.parseInt(length[0]);
        int question = Integer.parseInt(length[1]);

        Map<String, String> poketmonBook = new HashMap<>();
//        Map<Integer, String> poketmonBook2 = new HashMap<>();
        for (int i = 0; i < book; i++) {
            String poketmon = br.readLine();
            poketmonBook.put(poketmon, String.valueOf(i+1));
            poketmonBook.put(String.valueOf(i+1), poketmon);
//            poketmonBook2.put(i+1, poketmon);
        }

        for (int i = 0; i < question; i++) {
            bw.write(poketmonBook.get(br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
