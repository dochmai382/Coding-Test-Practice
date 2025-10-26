import java.io.*;
import java.util.*;

class Solution {
    private int N;
    private int M; 
    private List<List<Integer>> adj;
    private boolean[] isKnownTruth;
    private List<List<Integer>> parties;
    private Queue<Integer> queue = new LinkedList<>();
    
    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init(N);

        st = new StringTokenizer(br.readLine());
        int  truthCount = Integer.parseInt(st.nextToken());
    
        for (int i = 0; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            if (!isKnownTruth[person]) {
                isKnownTruth[person] = true;
                queue.add(person);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            for (int j = 0; j < size; j++) {
                int A = party.get(j);
                for (int k = j + 1; k < size; k++) {
                    int B = party.get(k);

                    adj.get(A).add(B);
                    adj.get(B).add(A);
                }
            }
        }
        
    }

    private void init(int n) {
        isKnownTruth = new boolean[n+1];
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        parties = new ArrayList<>();    
    }

    private int solve() {
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (!isKnownTruth[v]) {
                    isKnownTruth[v] = true;
                    queue.add(v);
                }
            }
        }

        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;

            for (int person : party) {
                if (isKnownTruth[person]) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) count++;
        }

        return count;
    }

    public String getResult() {
        return String.valueOf(solve());
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