package 대칭차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    public int solution(HashSet<Integer> hs1, HashSet<Integer> hs2) {

        HashSet<Integer> hsCopy = new HashSet<>(hs1);
        hs1.removeAll(hs2);
        hs2.removeAll(hsCopy);

        return hs1.size() + hs2.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        HashSet<Integer> hs1 = new LinkedHashSet<>();
        HashSet<Integer> hs2 = new LinkedHashSet<>();
        for (int i = 0; i < Integer.parseInt(s[0]); i++) {
            hs1.add(Integer.valueOf(arr1[i]));
        }
        for (int i = 0; i < Integer.parseInt(s[1]); i++) {
            hs2.add(Integer.valueOf(arr2[i]));
        }

        Main main = new Main();
        System.out.println(main.solution(hs1, hs2));
    }
}
