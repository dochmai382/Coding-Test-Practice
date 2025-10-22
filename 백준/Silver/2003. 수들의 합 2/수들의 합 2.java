import java.io.*;
import java.util.*;

class Solution {
	private int N;
	private int M;
	private int[] numbers;
	
	public void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private int solve(int[] arr, int m) {
		int count = 0;
		int sum = 0;
		int left = 0;
		
    	for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > m && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == m) count++;
        }
		
		return count;
	}
	
	public String getResult() {
		return String.valueOf(solve(numbers, M));
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