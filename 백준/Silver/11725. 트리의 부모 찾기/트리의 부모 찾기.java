import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
		
			int N = Integer.parseInt(br.readLine());

			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();			
			for (int i = 0; i <= N; i++) {
				adj.add(new ArrayList<>());
			}
			
			StringTokenizer st;
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				adj.get(u).add(v);
				adj.get(v).add(u);
			}
			
			int[] parent = new int[N+1];	
			Queue<Integer> queue = new LinkedList<>();
			
			queue.add(1);
			parent[1] = 1;
			
			while(!queue.isEmpty()) {
				int U = queue.poll();
				
				for (int V : adj.get(U)) {
					if (parent[V] == 0) {
						parent[V] = U;
						queue.add(V);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 2; i <= N; i++) {
				sb.append(parent[i]).append("\n");
			}

			bw.write(sb.toString());
		}
	}
}