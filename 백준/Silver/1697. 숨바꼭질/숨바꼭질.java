import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[] time = new int[100001];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(N);
            time[N] = 0;

            while (!queue.isEmpty()) {
                int X = queue.poll();

                if (X == K) {
                    bw.write(String.valueOf(time[X]));
                    return;
                }

                int[] next = {X+1, X-1, X*2};
                for (int Y : next) {
                    if (Y >= 0 && Y <= 100000) {
                        if (time[Y] == 0) {
                            time[Y] = time[X] + 1;
                            queue.add(Y);
                        }
                    }
                }
            }
        }    
    }
}