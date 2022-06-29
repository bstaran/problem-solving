package q11_문자열압축;


public class Main {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder answer = new StringBuilder();
            int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i - 1] == chars[i]) {
                if (i < chars.length -1 && chars[i+1]==chars[i]) count++;
                else {
                    count++;
                    answer.append(count);
                    count=1;
                }
            }
            answer.append(chars[i]);
        }

        System.out.println(answer);
        
        return "";
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.solution("KKHSSSSSSSE");
    }
}
