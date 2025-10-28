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
    
    private int M;
    private int N;
    private int[][] tomatoes;
    private int[][] days;
    
    private final int[] DR = {-1, 1, 0, 0};
    private final int[] DC = {0, 0, -1, 1};
    
    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        tomatoes = new int[N][M];
        days = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            } 
        }
    }
    
    private void bfs() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 1) {
                    // days[i][j] = 0;
                    queue.add(new Point(i, j));
                } else if (tomatoes[i][j] == -1) {
                    days[i][j] = -1;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentR = current.row;
            int currentC = current.col;
            
            for (int i = 0; i < 4; i++) {
                int nextR = currentR + DR[i];
                int nextC = currentC + DC[i];
                
                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
                    if (tomatoes[nextR][nextC] == 0 && days[nextR][nextC] == 0) {
                        days[nextR][nextC] = days[currentR][currentC] + 1;
                        queue.add(new Point(nextR, nextC));
                    }
                }
            }
        }
    }
    
    public String getResult() {
        bfs();
        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0 && days[i][j] == 0) {
                    return "-1";
                } else if (days[i][j] > maxDays) {
                    maxDays = days[i][j];
                }
            }
        }
        
        return String.valueOf(maxDays);
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