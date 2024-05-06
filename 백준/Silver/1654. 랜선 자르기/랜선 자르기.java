import java.io.*;
import java.util.*;

public class Main {

  /*
4 11
802
743
457
539

1 1
1

랜선의 길이을 계속 자를때 => 원하는 갯수을 구할 수 있는가?
   */

  private static int N, K, MAX = Integer.MIN_VALUE;
  private static int[] A;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static void input() throws IOException {
    String[] in = br.readLine().split(" ");
    K = Integer.parseInt(in[0]);
    N = Integer.parseInt(in[1]);
    A = new int[K + 1];

    for (int i = 1; i <= K; i++) {
      A[i] = Integer.parseInt(br.readLine());
      if (MAX < A[i]) MAX = A[i];
    }
  }

  private static boolean determination(final long LEN) {
    long sum = 0;
    for (int i = 1; i <= K; i++) {
      sum += (A[i] / LEN);
    }

    return sum >= N;
  }

  private static void pro() {
    long L = 0, R = Integer.MAX_VALUE, ans = 0;

    while (L <= R) {
      long mid = (L + R) / 2;
      if (determination(mid)) {
        ans = mid;
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }

    System.out.println(ans);
  }

  public static void main(String[] args) throws IOException {
    input();
    pro();
  }

  private static void print(int[][] arr) {
    for (final int[] ints : arr) {
      System.out.print(Arrays.toString(ints) + " ");
    }
  }
}