package 상수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(String.valueOf(new StringBuilder(st.nextToken()).reverse()));
        int n2 = Integer.parseInt(String.valueOf(new StringBuilder(st.nextToken()).reverse()));

        System.out.println(Math.max(n1, n2));

    }
}

