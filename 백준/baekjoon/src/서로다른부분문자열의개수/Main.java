package 서로다른부분문자열의개수;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<String> set = new HashSet<>();

        int size = s.length();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                set.add(s.substring(j, i+j+1));
            }
        }
        System.out.println(set.size());
    }
}
