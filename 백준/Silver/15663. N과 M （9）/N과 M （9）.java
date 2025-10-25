import java.util.*;
import java.io.*;

class Solution {
	private int N;
	private int M;
	private int[] numbers;
	private List<Integer> result = new ArrayList<>();
	private boolean[] used;
	private StringBuilder sb = new StringBuilder();
	
	public void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		used = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
	}
	
	private void solve(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}	
		
		int prev = 0;
		
		for (int i = 0; i < N; i++) {
			if (used[i] || numbers[i] == prev) continue;
			
			used[i] = true;
			result.add(numbers[i]);
			prev = numbers[i];
			
			solve(count + 1);
			
			used[i]  = false;
			result.remove(result.size() - 1);
		}
	}
	
	public String getResult() {
		solve(0);
		return sb.toString().trim();
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			Solution sol = new Solution();
			sol.input(br);
			bw.write(sol.getResult());
		}
	}
}