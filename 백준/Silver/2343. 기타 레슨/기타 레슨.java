import java.io.*;
import java.util.*;

public class Main {

  /*
9 3
1 2 3 4 5 6 7 8 9

1 1
1

랜선의 길이을 계속 자를때 => 원하는 갯수을 구할 수 있는가?
   */

  private static int N, M;
  private static int[] A;
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static void input() throws IOException {
    String[] in = br.readLine().split(" ");
    N = Integer.parseInt(in[0]);
    M = Integer.parseInt(in[1]);
    A = new int[N + 1];

    in = br.readLine().split(" ");
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(in[i - 1]);
    }
  }

  private static boolean determination(final int len) {
    int cnt = 1, sum = 0;
    for (int i = 1; i <= N; i++) {
      if (sum + A[i] > len) {
        cnt++;
        sum = A[i];
      } else {
        sum += A[i];
      }
    }
    return cnt <= M;
  }

  static void pro() {
    int L = A[1], R = 1000000000, ans = 0;
    for (int i = 1; i <= N; i++) L = Math.max(L, A[i]);  // 적어도 제일 긴 녹화본의 길이 만큼은 필요하다!
    // [L ... R] 범위 안에 정답이 존재한다! 
    // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
    while (L <= R) {
      int mid = (L + R) / 2;
      if (determination(mid)) {
        ans = mid;
        R = mid - 1;
      } else {
        L = mid + 1;
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