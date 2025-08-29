import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

             StringBuilder sb = new StringBuilder();
             StringTokenizer st;
             
             int N = Integer.parseInt(br.readLine());
             int[] cards = new int[N];
             st = new StringTokenizer(br.readLine());
             for (int i = 0; i < N; i++) {
                 cards[i] = Integer.parseInt(st.nextToken());
             }
             Arrays.sort(cards);

             int M = Integer.parseInt(br.readLine());
             st = new StringTokenizer(br.readLine());
             for (int i = 0; i < M; i++) {
                 int target = Integer.parseInt(st.nextToken());
                 
                 boolean flag = false;
                 int start = 0; 
                 int end = N - 1;

                 while (start <= end) {
                     int mid = (start + end) / 2;

                     if (cards[mid] == target) {
                         flag = true;
                         break;
                     } else if (cards[mid] < target) {
                         start = mid + 1;
                     } else {
                         end = mid - 1;
                     }
                 }
                 if (flag) {
                     sb.append(1).append(" ");
                 } else {
                     sb.append(0).append(" ");
                 }
             }

             bw.write(sb.toString());
         }       
    }
}