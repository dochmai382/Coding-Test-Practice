import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
             // 컴퓨터의 총 개수와 연결선 개수를 입력받는다.
             int computers = Integer.parseInt(br.readLine());
             int connections = Integer.parseInt(br.readLine());
             
             // 연결 지도 만들기
             boolean[][] map = new boolean[computers+1][computers+1];
    
             // 감염 확정 명단 만들기
             boolean[] infected = new boolean[computers+1];

             // 앞으로 확인할 목록 만들기
             Queue<Integer> queue = new LinkedList<>();
             
             // 연결 정보를 읽어서 "연결 지도"에 표시한다.
             StringTokenizer st;
             for (int i = 1; i <= connections; i++) {
                 st = new StringTokenizer(br.readLine());
                 int com1 = Integer.parseInt(st.nextToken());
                 int com2 = Integer.parseInt(st.nextToken());
                 map[com1][com2] = true;
                 map[com2][com1] = true;
             }

             // 2. 바이러스 퍼뜨리기 (탐색 시작)
             // 시작점 설정: 1번 컴퓨터를 감염시킨다.
             queue.add(1);
             infected[1] = true;
    
             // "앞으로 확인할 목록"이 빌 때까지 반복한다.
             while (!queue.isEmpty()) {
                 // 목록에서 컴퓨터를 하나 꺼낸다.
                 int current = queue.remove();

                 // 현재 컴퓨터와 연결된 모든 컴퓨터를 확인한다.
                 for (int next = 1; next <= computers; next++) {
                     // 조건1: 두 컴퓨터가 연결되어 있는가?
                     // 조건2: 그리고, 아직 감염되지 않았는가?
                     if (map[current][next] && !infected[next]) {
                         infected[next] = true;
                         queue.add(next);
                     }
                 }
             }
             
             // 3. 결과 계산 및 출력
             // 감염된 컴퓨터의 총 수를 센다.
             int total = 0;
             for (int i = 1; i <= computers; i++) {
                 if (infected[i]) {
                     total++;
                 }
             }
             bw.write(String.valueOf(total-1));
         }
    }
}