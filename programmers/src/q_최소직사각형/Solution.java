package q_최소직사각형;

public class Solution {
    public int solution(int[][] sizes) {
        int answer =0;
        int w = 0;
        int h = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        for (int i = 0; i < sizes.length; i++) {
            if (w < sizes[i][0]) {
                w = sizes[i][0];
            }
            if (h < sizes[i][1]) {
                h = sizes[i][1];
            }

            answer = w * h;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution.solution(arr));
    }
}