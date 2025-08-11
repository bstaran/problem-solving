import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    String S = br.readLine();

    StringBuilder sb = new StringBuilder();
    sb.append("I");
    sb.append("OI".repeat(Math.max(0, N)));
    String IOI = sb.toString();

    int count = 0;
    for (int i = 0; i < M; i++) {
      if (S.charAt(i) == 'I') {
        if (IOI.length() > M - i) {
          break;
        }
        if (S.startsWith(IOI, i)) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}
