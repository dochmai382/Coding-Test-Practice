import java.util.*;
import java.io.*;

class Main {
    private static int N, M;
    private static int[][] maze;
    private static int[][] distance;
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            maze = new int[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                }
            }

            distance = new int[N][M];
            bfs(0, 0);
            
            bw.write(String.valueOf(distance[N-1][M-1]));
        }
    }

    private static void bfs(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        queue.add(new Point(y, x));
        distance[y][x] = 1;

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            int currentY = current.y;
            int currentX = current.x;

            for (int i = 0; i < 4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    if (maze[nextY][nextX] == 1 && distance[nextY][nextX] == 0) {
                        distance[nextY][nextX] = distance[currentY][currentX] + 1;
                        queue.add(new Point(nextY, nextX));
                    }
                }
            }
        }
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}