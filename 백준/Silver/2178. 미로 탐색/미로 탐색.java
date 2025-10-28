import java.io.*;
import java.util.*;

class Solution {

    class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    private int N;
    private int M;
    private int[][] map;
    private int[][] distance;

    private final int[] DY = {-1, 1, 0, 0};
    private final int[] DX = {0, 0, -1, 1};
        
    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        distance = new int[N][M];
    }

    private void bfs(int r, int c) {        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        distance[r][c] = 1;

        while(!q.isEmpty()) {
            Point current = q.poll();
            int currentR = current.row;
            int currentC = current.col;

            for (int i = 0; i < 4; i++) {
                int nextR = currentR + DY[i];
                int nextC = currentC + DX[i];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
                    if (map[nextR][nextC] == 1 && distance[nextR][nextC] == 0) {
                        distance[nextR][nextC] = distance[currentR][currentC] + 1;
                        q.add(new Point(nextR, nextC));
                    }
                }
            }
        }
    }

    public String getResult() {
        bfs(0, 0);
        return String.valueOf(distance[N-1][M-1]);
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