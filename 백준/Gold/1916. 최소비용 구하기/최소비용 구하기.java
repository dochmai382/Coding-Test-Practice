import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    private int to;
    private long cost;

    public Edge(int to, long cost) {
        this.to = to;
        this.cost = cost;
    }

    public int getTo() { return this.to; }
    public long getCost() { return this.cost; }

    @Override
    public int compareTo(Edge other) {
        return Long.compare(this.cost, other.cost);
    }
}

class Solution {

    public long solve(int N, List<List<Edge>> graph, int startCity, int endCity) {
        
        final long INF = Long.MAX_VALUE;
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[startCity] = 0;
        pq.add(new Edge(startCity, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentCity = current.getTo();
            long currentCost = current.getCost();
            
            if (currentCost > dist[currentCity]) {
                continue;
            }

            for (Edge next : graph.get(currentCity)) {
                int nextCity = next.getTo();
                long edgeWeight = next.getCost();

                long newCost = currentCost + edgeWeight;

                if (newCost < dist[nextCity]) {
                    dist[nextCity] = newCost;
                    pq.add(new Edge(nextCity, newCost));
                }
            }
        }

        return dist[endCity];
    }   
}

class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                
                graph.get(start).add(new Edge(end, weight));
            }

            st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());

            Solution sol = new Solution();
            bw.write(String.valueOf(sol.solve(N, graph, startCity, endCity)));
        }
    }
}