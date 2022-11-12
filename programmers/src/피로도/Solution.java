package 피로도;

public class Solution {
    static int answer;
    static int[][] dungeons;
    static boolean[] check;

    public int solution(int k, int[][] dungeons) {

        Solution.dungeons = dungeons;
        check = new boolean[dungeons.length];

        dfs(k, 0);

        return answer;
    }

    private void dfs(int k, int idx) {

        for (int i = 0; i < dungeons.length; i++) {

            if (!check[i] && dungeons[i][0] <= k) {
                check[i]=true;
                dfs(k-dungeons[i][1], idx+1);
                check[i]=false;
            }

        }
        answer = Math.max(answer, idx);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
