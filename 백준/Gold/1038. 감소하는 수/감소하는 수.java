import java.util.*;
import java.io.*;

public class Main {
	static List<Long> list = new ArrayList<>();
	static int N;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		if(N <= 10) {
			System.out.print(N);
			return;
		} else if (N >= 1023) {
			System.out.print(-1);
			return;
		}

		for(int i = 0; i < 10; i++) {
			DFS(i);
		}

		Collections.sort(list);
		System.out.print(list.get(N));
	} // End of main

	private static void DFS(long num) {		
		list.add(num);		
		long modValue = num % 10;
		if(modValue == 0) {
			return;
		}
		
		for(long i=modValue-1; i>=0; i--) {
			long newValue = num * 10 + i;
			DFS(newValue);
		}
	} // End of DFS
} // End of Main class