package array.q3_가위바위보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public String solution(int A, int B) {
        String result = "";

        if (A == B) result = "D";
        else if(A-B==2) result = "B";
        else if(A-B==-2) result = "A";
        else if(A-B==1) result = "A";
        else if (A-B==-1) result = "B";

        return result;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(a[i]);
            B[i] = Integer.parseInt(b[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(main.solution(A[i],B[i]));
        }

        Set<Integer> s = new HashSet<>();
    }
}
