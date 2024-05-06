import java.io.*;
import java.util.*;

public class Main {

  /*
5 3
1
2
8
4
9

   */
  private static int N, C, MAX = Integer.MIN_VALUE;
  private static int[] arr;

  private static void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] in = br.readLine().split(" ");
    N = Integer.parseInt(in[0]);
    C = Integer.parseInt(in[1]);
    arr = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      if (MAX < arr[i]) {
        MAX = arr[i];
      }
    }
  }

  private static void pro() {
    Arrays.sort(arr);

    int L = 0, R = MAX, ans = 0;
    while (L <= R) {
      int mid = (L + R) / 2;
      if (determinate(mid)) {
        L = mid + 1;
        ans = mid;
      } else {
        R = mid - 1;
      }
    }

    System.out.println(ans);
  }

  private static boolean determinate(final int mid) {
    int cnt = 1;
    int last = arr[1];

    for (int i = 2; i <= N; i++) {
      if ((arr[i] - last) < mid) {
        continue;
      }
      last = arr[i];
      cnt++;
    }
    return cnt >= C;
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