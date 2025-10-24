import java.util.*;
import java.io.*;

class Solution {
	private int N;
	private int M;
	private int[] numbers;
	private List<Integer> result = new ArrayList<>();
	private StringBuilder sb = new StringBuilder();
	
	public void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		for (int i = 0;  i < N ;i++) {
			numbers[i] = i + 1;
		}
	}
	
	private void solve(int startIdx, int count) {
		if (count == M) {
			for (int num: result) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = startIdx; i < N; i++) {
			result.add(numbers[i]);
			solve(i + 1, count + 1);
			
			result.remove(result.size() - 1);
		}
	}
	
	public String getResult() {
		solve(0, 0);
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