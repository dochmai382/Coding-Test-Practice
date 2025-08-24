import java.util.*;
import java.io.*;

/*
A+: 4.3, A0: 4.0, A-: 3.7
B+: 3.3, B0: 3.0, B-: 2.7
C+: 2.3, C0: 2.0, C-: 1.7
D+: 1.3, D0: 1.0, D-: 0.7
F: 0.0
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            String input = br.readLine();
            double score = 0.0;

            switch (input) {
                case "A+": score = 4.3; break;
                case "A0": score = 4.0; break;
                case "A-": score = 3.7; break;
                case "B+": score = 3.3; break;
                case "B0": score = 3.0; break;
                case "B-": score = 2.7; break;
                case "C+": score = 2.3; break;
                case "C0": score = 2.0; break;
                case "C-": score = 1.7; break;
                case "D+": score = 1.3; break;
                case "D0": score = 1.0; break;
                case "D-": score = 0.7; break;
                case "F": score = 0.0; break;
            }

            bw.write(String.valueOf(score));
        }
    }
}