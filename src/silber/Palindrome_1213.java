package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String st = br.readLine();
        char[] ch = st.toCharArray();
        int[] alpha = new int[26];

        // 알파벳 수 세기
        for(int i=0; i<ch.length; i++){
            alpha[ch[i]-'A']++;
        }

        int temp = -1;
        boolean fail = false;
        // 홀수 찾기
        for(int i=0; i<alpha.length; i++){
            if(alpha[i]%2 != 0){
                if(temp == -1){
                    alpha[i]--;
                    temp = i;
                }else{
                    fail = true;
                    break;
                }
            }
        }

        // 출력하기
        if(fail){
            System.out.println("I'm Sorry Hansoo");
        }else{
            for(int i=0; i<alpha.length; i++){
                while (alpha[i] > 0 && alpha[i]/2 > 0){
                    sb.append((char) (i+'A'));
                    alpha[i] -= 2;
                }
            }

            System.out.print(sb);
            if(temp != -1){
                System.out.print((char)(temp+'A'));
            }
            sb.reverse();
            System.out.print(sb);
        }


    }
}
