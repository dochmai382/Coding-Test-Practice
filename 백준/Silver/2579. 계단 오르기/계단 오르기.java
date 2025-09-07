import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            // 1. 입력받기 및 준비
            int N = Integer.parseInt(br.readLine());
            
            int[] stairs = new int[N+1];
            for (int i = 1; i <= N; i++) {
                stairs[i] = Integer.parseInt(br.readLine());
            }

            // 각 계단까지의 최대 점수를 저장할 배열 만들기
            int[] max = new int[N+1];
            
            // 2. 초기값 설정
            max[1] = stairs[1];

            // (계단이 2개 이상일 경우) 2번 계단까지의 최대 점수
            if (N >= 2) {
                max[2] = stairs[1] + stairs[2];
            }

            // 3. 점화식 적용 (최대 점수 계산)
            // 3번 계단부터 마지막 계단까지 반복
            for (int i = 3; i <= N; i++) {
                // i번째 계단으로 오는 두 가지 경로의 점수를 계산
        
                // 경로 1: i-2번 계단에서 두 칸 점프해서 도착한 경우
                // (i-2번 계단까지의 최대 점수)
                int path1 = max[i-2];
                                
                // 경로 2: i-1번 계단에서 한 칸 걸어와서 도착한 경우
                // (i-3번까지의 최대 점수 + i-1번 계단 점수)
                int path2 = max[i-3] + stairs[i-1];
                                
                // 두 경로 중 더 높은 점수를 선택하고, 현재 계단 점수를 더한다
                max[i] = Math.max(path1, path2) + stairs[i];
            }

            // 4. 최종결과 출력
            bw.write(String.valueOf(max[N]));          
        }
    }
}
