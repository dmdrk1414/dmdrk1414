import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static List<Integer>[] graph;
  static boolean[] visited;
  static boolean[] visited_all;
  static int MAX = Integer.MIN_VALUE;
  static int result;

  /*
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7

   */
  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt();
    M = scan.nextInt();
    graph = new List[N];
    visited = new boolean[N];
    visited_all = new boolean[N];
    for (int i = 0; i < N; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      int one = scan.nextInt();
      int two = scan.nextInt();

      graph[one].add(two);
      graph[two].add(one);
    }
  }

  static void pro() {
    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      recul(i, 1);
    }
    if (MAX >= 5) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
  }

  private static void recul(final int x, final int len) {
    visited[x] = true;
    MAX = Math.max(MAX, len);
    if (len == 5) {
      System.out.println(1);
      System.exit(0);
    }

    for (final Integer value : graph[x]) {
      if (!visited[value]) {
        recul(value, len + 1);
        visited[value] = false;
      }
    }
  }

  static void print(List<int[]> arr) {
    for (final int[] ints : arr) {
      System.out.println(ints[0] + " " + ints[1]);
    }
  }

  public static void main(String[] args) {
    input();
    pro();
  }

  private static void print(final boolean[][] arr) {
    for (final boolean[] booleans : arr) {
      System.out.println(Arrays.toString(booleans));
    }
  }

  static void print(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}