import java.util.*;
import java.io.*;

/*
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 
나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
*/

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            List<Member> members = new ArrayList<>();

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                members.add(new Member(age, name));
            }

            Collections.sort(members, (m1, m2) -> {
                return m1.getAge() - m2.getAge();
            });

            StringBuilder sb = new StringBuilder();
            for (Member m : members) {
                sb.append(m).append("\n");
            }

            bw.write(sb.toString());            
        }
    }
}

class Member {
    int age;
    String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return age + " " + name;
    }
}