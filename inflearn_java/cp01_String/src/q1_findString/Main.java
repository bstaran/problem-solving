package q1_findString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String c = br.readLine();

        int count = 0;

        for (int i = 0; i < word.length(); i++) {

            if (Character.isUpperCase(word.charAt(i))) {
                boolean b = word.charAt(i) == c.toUpperCase().charAt(0);
                if (b) {
                    count += 1;
                }
            } else {
                boolean b = word.charAt(i) == c.toLowerCase().charAt(0);
                if (b) {
                    count += 1;
                }
            }
        }
        System.out.println(count);

//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        char c = kb.next().charAt(0);
//
//        System.out.println(T.solution(str, c));
    }

//    public int solution(String str, char t) {
//        int answer = 0;
//
//        str = str.toUpperCase();
//        t = Character.toUpperCase(t);
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == t) answer++;
//        }
//
//        return answer;
//    }
}

