import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            int M = Integer.parseInt(br.readLine());
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());

                boolean flag = false;
                int start = 0;
                int end = N - 1;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (A[mid] == target) {
                        flag = true;
                        break;
                    } else if (A[mid] < target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                if (flag) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            
            bw.write(sb.toString());
        }
    }
}