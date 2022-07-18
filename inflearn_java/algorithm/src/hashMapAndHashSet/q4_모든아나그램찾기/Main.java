package hashMapAndHashSet.q4_모든아나그램찾기;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String strToFind = sc.nextLine();

        int answer = 0;

        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strToFind.length(); i++) hashMap.put(strToFind.charAt(i), hashMap.getOrDefault(strToFind.charAt(i), 0)+1);
        HashMap<Character,Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < strToFind.length(); i++) hashMap2.put(str.charAt(i), hashMap2.getOrDefault(str.charAt(i), 0)+1);
        if (hashMap.equals(hashMap2)) answer++;
        int rt = strToFind.length();
        for (int lt = 1; rt < str.length(); lt++, rt++) {
            if (hashMap2.get(str.charAt(lt-1))==1) hashMap2.remove(str.charAt(lt-1));
            else hashMap2.put(str.charAt(lt-1), hashMap2.get(str.charAt(lt-1))-1);
            hashMap2.put(str.charAt(rt), hashMap2.getOrDefault(str.charAt(rt), 0)+1);

            if (hashMap.equals(hashMap2)) answer++;
        }

        System.out.println(answer);
    }
}
