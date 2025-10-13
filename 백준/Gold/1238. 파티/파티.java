import java.util.*;
import java.io.*;

class Solution {

    static class Edge implements Comparable<Edge> {
        private int city;
        private long cost;

        public Edge(int city, long cost) {
            this.city = city;
            this.cost = cost;
        }
        public int getCity() { return this.city; }
        public long getCost() { return this.cost; }
        
        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.cost, other.cost);
        }
    }
    
    private int N;
    private int M; 
    private int X; 
    private List<List<Edge>> graph;
    private List<List<Edge>> reversedGraph;

    private static final Long INF = 500_000_000L;

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        init(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            reversedGraph.get(b).add(new Edge(a, c));
        }
    }

    private void init(int n) {
        graph = new ArrayList<>();
        reversedGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reversedGraph.add(new ArrayList<>());
        }
    }

    private long[] dijkstra(List<List<Edge>> g) {
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[X] = 0;
        pq.add(new Edge(X, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentCity = current.getCity();
            long currentCost = current.getCost();

            if (currentCost > dist[currentCity]) continue;

            for (Edge next : g.get(currentCity)) {
                int nextCity = next.getCity();
                long weight = next.getCost();

                long newCost = currentCost + weight;

                if (newCost < dist[nextCity]) {
                    dist[nextCity] = newCost;
                    pq.add(new Edge(nextCity, newCost));
                }
            }
        }

        return dist;
    }
    
    public String getResult() {
        long[] distFromX = dijkstra(graph);
        long[] distToX = dijkstra(reversedGraph);

        long maxTime = 0L;
        for (int i = 1; i <= N; i++) {
            long total = distFromX[i] + distToX[i];

            if (maxTime < total) {
                maxTime = total;
            }
        }

        return String.valueOf(maxTime);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Solution sol = new Solution();
            sol.input(br);
            bw.write(sol.getResult());
        }
    }
}