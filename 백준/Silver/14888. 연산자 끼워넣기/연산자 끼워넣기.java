import java.io.*;
import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N;
  static int[] numbers;
  static int[] operator;
  static int MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;

  static void input() {
    FastReader scan = new FastReader();
    N = scan.nextInt();
    numbers = new int[N];
    operator = new int[4];
    for (int i = 0; i < N; i++) {
      numbers[i] = scan.nextInt();
    }
    for (int i = 0; i < 4; i++) {
      operator[i] = scan.nextInt();
    }
  }

  // Recurrence Function (재귀 함수)
  // 만약 M 개를 전부 고름   => 조건에 맞는 탐색을 한 가지 성공한 것!
  // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
  static void rec_func(int num, int idx) {
    if (idx == N) {
      MIN = Math.min(MIN, num);
      MAX = Math.max(MAX, num);
      return;
    } else {
      for (int i = 0; i < operator.length; i++) {
        if (operator[i] > 0) {
          operator[i]--;
          if (i == 0) {
            rec_func(num + numbers[idx], idx + 1);
          } else if (i == 1) {
            rec_func(num - numbers[idx], idx + 1);
          } else if (i == 2) {
            rec_func(num * numbers[idx], idx + 1);
          } else if (i == 3) {
            rec_func(num / numbers[idx], idx + 1);
          }
          operator[i]++;
        }
      }
    }
  }

  public static void main(String[] args) {
    input();
    rec_func(numbers[0], 1);
    System.out.println(MAX);
    System.out.println(MIN);
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