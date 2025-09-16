import java.util.*;
import java.io.*;

/*
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
길이가 짧은 것부터
길이가 같으면 사전 순으로
단, 중복된 단어는 하나만 남기고 제거해야 한다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            
            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                set.add(word);
            }

            ArrayList<String> list = new ArrayList<>(set);
            Collections.sort(list, (s1, s2) -> {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                return s1.compareTo(s2);
            });

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append("\n");
            }
            bw.write(sb.toString());
        }
    }
}