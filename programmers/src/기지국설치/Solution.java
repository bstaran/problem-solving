package 기지국설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int left = 1;
        for (int station : stations) {
            int right = station - w;

            if (left < right) {
                answer += (right - left) / (w * 2 + 1);
                if ((right - left) % (w * 2 + 1) != 0) {
                    answer++;
                }
            }
            left = station + w + 1;
        }

        if (left < n + 1) {
            answer += (n + 1 - left) / (w * 2 + 1);

            if ((n + 1 - left) % (w * 2 + 1) != 0) {
                answer++;
            }
        }

        return answer;
    }
}