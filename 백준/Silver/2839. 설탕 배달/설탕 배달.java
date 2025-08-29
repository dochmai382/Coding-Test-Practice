import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

             StringBuilder sb = new StringBuilder();
             
             int N = Integer.parseInt(br.readLine());
             int fiveCnt = N / 5;
             int threeCnt = 0;

             while (fiveCnt >= 0) {
                 int remainder = N - (5 * fiveCnt);
                 if (remainder % 3 == 0) {
                     threeCnt = remainder / 3;
                     break;
                 } else {
                     fiveCnt--;
                 }
             }

             if (fiveCnt == 0 && threeCnt == 0) {
                 sb.append(-1);
             } else {
                 sb.append(fiveCnt + threeCnt);    
             }
             
             bw.write(sb.toString());
         }       
    }
}