import java.util.*;
import java.io.*;

class Solution {
	static class Point {
		private int r;
		private int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public int getR() { return r; }
		public int getC() { return c; }
	}
	
	private int N;
	private int M;
	private List<Point> houses = new ArrayList<>();
	private List<Point> allChickens = new ArrayList<>();
	
	private int minCityDistance = Integer.MAX_VALUE;
	private List<Point> selected = new ArrayList<>();	

	public void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int city = Integer.parseInt(st.nextToken());
				if (city == 1) {
					houses.add(new Point(i, j));
				} else if(city == 2) {
					allChickens.add(new Point(i, j));
				} else continue;
			}
		}
	}
	
	private void selectChicken(int startIdx, int count) {
		if (count == M) {
			calculate();
			return;
		}
		
		for (int i = startIdx; i < allChickens.size(); i++) {
			selected.add(allChickens.get(i));
			selectChicken(i + 1, count + 1);
			selected.remove(selected.size() - 1);
		}
	}
	
	private void calculate() {
		int current = 0;
		for (Point house : houses) {
			 int minHouseDist = Integer.MAX_VALUE;
			 
			 for (Point chicken : selected) {
				 int dist = Math.abs(house.getR() - chicken.getR()) + Math.abs(house.getC() - chicken.getC());
				 minHouseDist = Math.min(minHouseDist, dist);
			 }
			 
			 current += minHouseDist;
		}
		minCityDistance = Math.min(minCityDistance, current);
	}
	
	public int solve() {
		selectChicken(0, 0);
		return minCityDistance;
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
			bw.write(String.valueOf(sol.solve()));
		}
	}
}