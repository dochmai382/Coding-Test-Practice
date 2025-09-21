import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input = br.readLine();
            Set<String> set = new HashSet<>();

            for (int i = 0; i < input.length(); i++) {
                for (int j = i+1; j <= input.length(); j++) {
                    String str = input.substring(i, j);
                    set.add(str);
                }
            }
            
            bw.write(String.valueOf(set.size()));
        }    
    } 
}