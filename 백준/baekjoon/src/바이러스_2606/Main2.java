package 바이러스_2606;

import java.io.*;

public class Main2 {

	static int[][] list;
	static boolean[] visit;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		list = new int[n+1][n+1];
		visit = new boolean[n+1];

		for (int i = 0; i < k; i++) {
			String[] c = br.readLine().split(" ");
			int p1 = Integer.parseInt(c[0]);
			int p2 = Integer.parseInt(c[1]);
			list[p1][p2] = 1;
			list[p2][p1] = 1;
		}

		dfs(1, n);
		System.out.println(count-1);
	}

	static void dfs(int s,  int n) {
		visit[s] = true;

		for (int i = 1; i <= n; i++) {
			if (list[s][i] == 1 && !visit[i]) {
				dfs(i, n);
			}
		}

		count++;
	}
}
