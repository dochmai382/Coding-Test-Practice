import java.util.*;
import java.io.*;

class Point {
    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    private int N;
    private char[][] input;
    private boolean[][] visited;
    private int countNormal;
    private int countColorBlind;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public Solution(int N, char[][] input) {
        this.N = N;
        this.input = input;
    }

    private void bfs(int startR, int startC, char[][] grid) {
        Queue<Point> queue = new LinkedList<>();

        visited[startR][startC] = true;
        queue.add(new Point(startR, startC));

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            char currentColor = grid[current.r][current.c];

            for (int i = 0; i < 4; i++) {
                int nextR = current.r + dr[i];
                int nextC = current.c + dc[i];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N) {
                    if (!visited[nextR][nextC]) {
                        if (grid[nextR][nextC] == currentColor) {
                            visited[nextR][nextC] = true;
                            queue.add(new Point(nextR, nextC));
                        }
                    }
                }
            }          
        }
    }

    public String solve() {
        this.visited = new boolean[N][N];
        char[][] normalGrid = this.input;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    countNormal++;
                    bfs(r, c, normalGrid);
                }
            }
        }

        char[][] colorBlindGrid = new char[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (input[r][c] == 'G') {
                    colorBlindGrid[r][c] = 'R';
                } else {
                    colorBlindGrid[r][c] = this.input[r][c]; 
                }
            }
        }
        this.visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c <N; c++) {
                if (!visited[r][c]) {
                    countColorBlind++;
                    bfs(r, c, colorBlindGrid);
                }
            }
        }
        
        return countNormal + " " + countColorBlind;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            char[][] input = new char[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    input[i][j] = line.charAt(j);
                }
            }

            Solution sol = new Solution(N, input);
            bw.write(sol.solve());
        }
    }
}