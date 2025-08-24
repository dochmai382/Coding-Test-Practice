import java.util.*;
import java.io.*;

/*
연산자의 기호는 ＠으로, A＠B = (A+B)×(A-B)으로 정의내리기로 했다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = (a + b) * (a - b);
            bw.write(String.valueOf(result));            
        }
    }
}