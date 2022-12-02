package 모음사전;

public class Solution {
    public int solution(String word) {
        int answer = 0;

        String str = "AEIOU";
        int maxNum = 3905;
        for (String s : word.split("")) {
            answer+=str.indexOf(s)*(maxNum/=5)+1;
        }

        return answer;
    }
}
