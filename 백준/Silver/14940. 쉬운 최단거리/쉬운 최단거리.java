import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] distance = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    distance[i][j] = -1;
                }
            }
            
            int[][] map = new int[n][m];
            Point goal = new Point(0, 0);
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 2) {
                        goal = new Point(i, j);
                        distance[i][j] = 0;
                    } else if (map[i][j] == 0) {
                        distance[i][j] = 0;
                    }
                }
            }

            Queue<Point> q = new LinkedList<>();
            q.add(goal);

            while (!q.isEmpty()) {
                Point current = q.poll();
                int currentY = current.y;
                int currentX = current.x;

                for (int i = 0; i < 4; i++) {
                    int nextY = currentY + dy[i];
                    int nextX = currentX + dx[i];

                    if (0 <= nextY && nextY < n && 0 <= nextX && nextX < m) {
                        if (distance[nextY][nextX] == -1) {
                            if (map[nextY][nextX] == 1) {
                                distance[nextY][nextX] = distance[currentY][currentX] + 1;
                                q.add(new Point(nextY, nextX));
                            }
                        }
                    }                    
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (distance[i][j] == -1 && map[i][j] == 1) {
                        sb.append(-1).append(" ");
                    } else {
                        sb.append(distance[i][j]).append(" ");
                    }
                }
                sb.append("\n");
            }
                      
            bw.write(sb.toString().trim());
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