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
    private int V;
    private int E;
    private int start;
    private List<List<Edge>> graph;
    private long[] dist;

    private final long INF = Long.MAX_VALUE;

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        this.V = Integer.parseInt(st.nextToken());
        this.E = Integer.parseInt(st.nextToken());

        this.start = Integer.parseInt(br.readLine());
        
        this.graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            this.graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }
    }

    private void solve() {
        this.dist = new long[V+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[this.start] = 0;
        pq.add(new Edge(this.start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentTo = current.getTo();
            long currentCost = current.getCost();

            if (currentCost > dist[currentTo]) {
                continue;
            }

            for (Edge next : graph.get(currentTo)) {
                int nextTo = next.getTo();
                long nextCost = next.getCost();

                long newCost = nextCost + currentCost;
                if (newCost < dist[nextTo]) {
                    dist[nextTo] = newCost;
                    pq.add(new Edge(nextTo, newCost));
                }
            }
        }
    }

    public String getResult() {
        solve();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        return sb.toString().trim();
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