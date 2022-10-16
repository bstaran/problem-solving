package 숫자문자열과영단어;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < alphabets.length; i++) {
            s=s.replace(alphabets[i], Integer.toString(i));
        }

        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("2three45sixseven"));
    }
}
