import java.io.*;
import java.util.*;

class Solution {
	static class Point {
		int row;
		int col;
		
		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	private int N;
	private int M;
	private char[][] map;
	private boolean[][] visited;
	Queue<Point> queue = new LinkedList<>();
	
	private final int[] dy = {-1, 1, 0, 0};
	private final int[] dx = {0, 0, -1, 1};
	
	public void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0;i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'I') {
					queue.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}
	}
	
	private int solve() {
		int count = 0;
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			int currentR = current.row;
			int currentC = current.col;
			
			for (int i = 0;i < 4; i++) {
				int nextR = currentR + dy[i];
				int nextC = currentC + dx[i];
				
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
					if (map[nextR][nextC] != 'X' && !visited[nextR][nextC]) {
						visited[nextR][nextC] = true;
                        if (map[nextR][nextC] == 'P') {
                            count++;
                        }
						queue.add(new Point(nextR, nextC));
					}
				}
			}
		}
		
		return count;
	}
	
	public String getResult() {
        int result = solve();
        if (result != 0) {
            return String.valueOf(result);
        } else {
            return "TT";
        }
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