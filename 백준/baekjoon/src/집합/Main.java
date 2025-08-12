package 집합;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < M; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            switch (operator) {
                case "add":
                    hashSet.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    hashSet.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    if (hashSet.contains(Integer.parseInt(st.nextToken()))) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                case "toggle":
                    int n = Integer.parseInt(st.nextToken());
                    if (hashSet.contains(n)) hashSet.remove(n);
                    else hashSet.add(n);
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) hashSet.add(j);
                    break;
                case "empty":
                    hashSet = new HashSet<>();
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
