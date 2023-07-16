package 랜선자르기_1654;

import java.io.*;

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int k = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);

		int[] cables = new int[k];
		long max = 0;
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());
			if (max < num) max = num;
			cables[i] = num;
		}

		long l = 0, r = max + 1, mid = 0;
		while(l < r) {
			mid = (l + r) / 2;
			int sum = 0;
			for (int i = 0; i < k; i++) {
				sum += cables[i] / mid;
			}

			if (sum < n) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(r - 1);
	}
}
