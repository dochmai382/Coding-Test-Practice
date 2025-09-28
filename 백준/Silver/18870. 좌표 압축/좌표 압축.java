import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


class Main {
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> unique = Arrays.stream(input)
                                            .boxed()
                                            .collect(Collectors.toSet());
            List<Integer> list = new ArrayList<>(unique);
            Collections.sort(list);

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), i);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(map.get(input[i])).append(" ");
            }

            bw.write(sb.toString().trim());
        }    
    }
}