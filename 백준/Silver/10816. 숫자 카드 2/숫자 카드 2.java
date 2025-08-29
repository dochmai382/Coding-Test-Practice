import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int current = Integer.parseInt(st.nextToken());
                map.put(current, map.getOrDefault(current, 0) + 1);
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());

                sb.append(map.getOrDefault(target, 0)).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}