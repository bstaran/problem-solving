package 행렬의곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = multiply(i, j, arr1, arr2);
            }
        }
        return answer;
    }

    public int multiply(int row, int column, int[][] arr1, int[][] arr2) {
        int result = 0;
        for (int i = 0; i < arr1[0].length; i++) {
            result += arr1[row][i] * arr2[i][column];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
    }
}