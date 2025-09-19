import java.util.*;
import java.io.*;

/*
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 
이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, 
N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.

듣보잡의 수와 그 명단을 사전순으로 출력한다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<String> no_listen = new HashSet<>();
            for (int i = 0; i < N; i++) {
                String name = br.readLine();
                no_listen.add(name);
            }

            List<String> result = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String name = br.readLine();
                if (no_listen.contains(name)) {
                    result.add(name);
                }
            }
            Collections.sort(result);

            StringBuilder sb = new StringBuilder();
            sb.append(result.size()).append("\n");
            for (String name: result) {
                sb.append(name).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}