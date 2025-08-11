import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String S = br.readLine();

    String IOI = "I" + "OI".repeat(Math.max(0, N));
    int[] pi = new int[IOI.length()];
    for (int i = 1, j = 0; i < IOI.length(); i++) {
      while (j > 0 && IOI.charAt(i) != IOI.charAt(j)) {
        j = pi[j - 1];
      }
      if (IOI.charAt(i) == IOI.charAt(j)) {
        pi[i] = ++j;
      }
    }

    int count = 0;
    for (int i = 0, j = 0; i < M; i++) {
      while (j > 0 && S.charAt(i) != IOI.charAt(j)) {
        j = pi[j - 1];
      }
      if (S.charAt(i) == IOI.charAt(j)) {
        if (j == IOI.length() - 1) {
          count++;
          j = pi[j];
        } else {
          j++;
        }
      }
    }

    System.out.println(count);
  }
}
