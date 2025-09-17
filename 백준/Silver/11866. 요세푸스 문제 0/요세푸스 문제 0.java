import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                queue.add(i);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("<");
            while(!queue.isEmpty()) {
                for (int i = 0; i < K-1; i++) {
                    int num = queue.poll();
                    queue.add(num);
                }
                sb.append(queue.poll()).append(", ");
            }

            sb.delete(sb.length()-2, sb.length());
            sb.append(">");
            bw.write(sb.toString());
        }
    }
}