import java.util.*;
import java.io.*;

class Solution {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int N;
    private int[][] map;
    private List<Integer> result = new ArrayList<>();
    private boolean[][] visited;
    
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    
    public void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private int solve(int startX, int startY) {
        int count = 1;
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new Point(nextX, nextY));
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public String getResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = solve(i, j);
                    result.add(size);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        
        Collections.sort(result);
        for (int count: result) {
            sb.append(count).append("\n");
        }

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