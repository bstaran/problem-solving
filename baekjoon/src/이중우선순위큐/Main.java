package 이중우선순위큐;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    treeMap.put(n, treeMap.getOrDefault(n, 0)+1);
                } else if (command.equals("D")) {
                    if (treeMap.isEmpty()) continue;

                    if (n == 1) {
                        int key = treeMap.lastKey();
                        if (treeMap.get(key)==1) treeMap.pollLastEntry();
                        else treeMap.put(key, treeMap.get(key)-1);
                    }
                    else if (n == -1) {
                        int key = treeMap.firstKey();
                        if (treeMap.get(key)==1) treeMap.pollFirstEntry();
                        else treeMap.put(key, treeMap.get(key)-1);
                    }
                }
            }
            if (treeMap.isEmpty()) bw.write("EMPTY" + "\n");
            else bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
