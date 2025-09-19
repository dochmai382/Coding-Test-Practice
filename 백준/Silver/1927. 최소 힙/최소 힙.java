import java.util.*;
import java.io.*;

/*
첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, 
x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
입력에서 0이 주어진 횟수만큼 답을 출력한다. 
만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(br.readLine());
                if (x == 0) {
                    if (minHeap.isEmpty()) {
                        sb.append(0).append("\n");
                    } else {
                        sb.append(minHeap.poll()).append("\n");
                    }
                } else {
                    minHeap.add(x);
                }
            }
            bw.write(sb.toString());
        }
    }
}