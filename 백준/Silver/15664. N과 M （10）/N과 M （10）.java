import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] arr, selected;
  static List<int[]> list;
  static Set<String> set = new LinkedHashSet<>();

  /*
4 2
9 7 9 1

   */
  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt();
    M = scan.nextInt();
    arr = new int[N];
    selected = new int[M];
    list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      arr[i] = scan.nextInt();
    }
    Arrays.sort(arr);
  }


  private static void recur(final int idx, final int start) {
    if (idx == M) {
      sb = new StringBuilder();
      for (int i = 0; i < M; i++) {
        sb.append(selected[i]).append(" ");
      }
      set.add(sb.toString());
      return;
    } else {
      for (int i = start; i < N; i++) {
        selected[idx] = arr[i];
        recur(idx + 1, i + 1);
        selected[idx] = 0;
      }
    }
  }

  static void pro() {
    recur(0, 0);
    for (String s : set) {
      System.out.println(s);
    }
  }

  static void print(List<int[]> arr) {
    for (final int[] ints : arr) {
      System.out.println(ints[0] + " " + ints[1]);
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

  public static void main(String[] args) {
    input();
    pro();
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