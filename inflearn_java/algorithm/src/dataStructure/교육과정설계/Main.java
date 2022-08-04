package dataStructure.교육과정설계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        Main main = new Main();
        System.out.println(main.solution(s1, s2));
    }

    private String solution(String s1, String s2) {

        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) q.offer(s1.charAt(i));
        char c = q.poll();
        for (int i = 0; i < s2.length(); i++) {
            if (i==s2.length()-1) break;
            if (q.isEmpty()) return "YES";
            if (c==s2.charAt(i)) c = q.poll();
        }

        return "NO";
    }
}
