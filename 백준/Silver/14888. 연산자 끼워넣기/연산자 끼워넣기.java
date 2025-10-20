import java.util.*;
import java.io.*;

class Solution {
	private int N;
	private int[] numbers;
	private int[] operators = new int[4];
	private long maxResult = Long.MIN_VALUE;
	private long minResult = Long.MAX_VALUE;
	
	public void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0;i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private void selectOperator(int numIndex, long currentValue) {
		if (numIndex == N) {
			maxResult = Math.max(maxResult, currentValue);
			minResult = Math.min(minResult, currentValue);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				
				long nextValue = calculate(currentValue, numbers[numIndex], i);
				selectOperator(numIndex + 1, nextValue);
				
				operators[i]++;
			}
		}
	}
	
	private long calculate(long value, int number, int operator) {
		if (operator == 0) {
			return value + number;
		} else if (operator == 1) {
			return value - number;
		} else if (operator == 2) {
			return value * number;
		} else {
			return value / number;
		}
	}
 
	public String getResult() {
		selectOperator(1, numbers[0]);
		StringBuilder sb = new StringBuilder();
		sb.append(maxResult).append("\n").append(minResult);
		return sb.toString();
		
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