import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            int result = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < N+1; i++) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                int[] distance = new int[N+1];
                Arrays.fill(distance, -1);
                distance[i] = 0;

                while(!queue.isEmpty()) {
                    int current = queue.poll();

                    for (int next = 1; next <= N; next++) {
                        if (arr[current][next] == 1 && distance[next] == -1) {
                            distance[next] = distance[current] + 1;
                            queue.add(next);
                        } 
                    }
                }

                int currentSum = 0;
                for (int j = 1; j < N+1; j++) {
                    currentSum += distance[j];
                }

                if (currentSum < min) {
                    min = currentSum;
                    result = i;
                }
            }

            bw.write(String.valueOf(result));            
        }
    }
}