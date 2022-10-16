package 시저암호;

public class Solution {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;

            if (Character.isUpperCase(chars[i])) {
                if (chars[i] + n > 90) {
                    chars[i] = (char) (65 + ((chars[i] + n - 1) % 90));
                } else {
                    chars[i] = (char) (chars[i] + n);
                }
            } else if (Character.isLowerCase(chars[i])) {
                if (chars[i] + n > 122) {
                    chars[i] = (char) (97 + ((chars[i] + n - 1) % 122));
                } else {
                    chars[i] = (char) (chars[i] + n);
                }
            }
        }
        String answer = String.valueOf(chars);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("z", 1));
    }
}
