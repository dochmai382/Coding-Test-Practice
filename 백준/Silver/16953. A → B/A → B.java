import java.util.*;
import java.io.*;

class Solution {
    private long A;
    private long B;

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());       
    }

    public int solve() {
        int count = 1;

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
                count++;
            } else {
                if (B % 10 == 1) {
                    B = (B - 1) / 10;
                    count++;
                } else {
                    return -1;
                }
            }
        }

        if (B == A) {
            return count;
        } else {
            return -1;
        }
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
            bw.write(String.valueOf(sol.solve()));
        }
    }
}