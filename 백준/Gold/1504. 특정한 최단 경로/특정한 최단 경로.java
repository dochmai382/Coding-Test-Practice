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
    private int N;
    private int E; 
    private List<List<Edge>> graph;
    private int v1;
    private int v2;
    
    private final long INF = 500_000_000_000L;

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        this.N = Integer.parseInt(st.nextToken());
        this.E = Integer.parseInt(st.nextToken());
        init(N);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            this.graph.get(a).add(new Edge(b, c));
            this.graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        this.v1 = Integer.parseInt(st.nextToken());
        this.v2 = Integer.parseInt(st.nextToken());
    }

    private void init(int N) {
        this.graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    private long[] dijkstra(int start) {
        long[] currentDist = new long[N+1];
        Arrays.fill(currentDist, INF);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        currentDist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentTo = current.getTo();
            long currentCost = current.getCost();

            if (currentCost > currentDist[currentTo]) continue;

            for (Edge next : graph.get(currentTo)) {
                int nextTo = next.getTo();
                long nextWeight = next.getCost();

                long newCost = currentCost + nextWeight;
                if (newCost < currentDist[nextTo]) {
                    currentDist[nextTo] = newCost;
                    pq.add(new Edge(nextTo, newCost));
                }
            }
        }

        return currentDist;
    }

    public String getResult() {
        long[] dist1 = dijkstra(1);
        long[] distV1 = dijkstra(this.v1);
        long[] distV2 = dijkstra(this.v2);

        long path1 = -1;
        // 1 -> v1 -> v2 -> N
        if (dist1[v1] != INF && distV1[v2] != INF && distV2[N] != INF) {
            path1 = dist1[v1] + distV1[v2] + distV2[N];
        }

        long path2 = -1;
        // 1 -> v2 -> v1 -> N
        if (dist1[v2] != INF && distV2[v1] != INF && distV1[N] != INF) {
            path2 = dist1[v2] + distV2[v1] + distV1[N];
        }

        long result;
        if (path1 != -1 && path2 != -1) {
            result = Math.min(path1, path2);
        } else if (path1 != -1) {
            result = path1;
        } else if (path2 != -1) {
            result = path2;
        } else {
            result = -1;
        }

        return String.valueOf(result);
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