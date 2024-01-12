package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while((input = br.readLine()) != null){
            int n = Integer.parseInt(input);
            // n * 1 ~ * 9 까지 뒤의 자리가 오름차순으로 배열에 저장
            String ten[] = new String[10];
            for(int i=1; i<=10; i++){
                String number = Integer.toString(n*i);
                // 숫자 맨 끝자리에 맞게 배열에 곱한 값 넣기
                ten[number.charAt(number.length()-1)-'0'] = number;
            }

            // 뒷자리 1인 수를 찾아서 count + 1 하고, 뒤에 1 지우기
            int count = 0;
            String now = ten[1];
            while (now.length() > 0){
                // 뒤의 값 1 지우기
                while(now.charAt(now.length()-1)=='1'){
                    now = now.substring(0, now.length()-1);
                    count++;
                    if(now.length() == 0){
                        break;
                    }
                }
                if(now.length() == 0){
                    break;
                }
                // 지운 값의 뒷자리에서 더하면 1되는 수 찾기
                int nowLast = now.charAt(now.length()-1)-'0';
                int index = 0;
                if(nowLast == 0){
                    index = 1;
                }else if(nowLast >= 2){
                    index = 11 - nowLast;
                }
                // 현재값이랑 11되는 값이랑 더하기
                now = Integer.toString(Integer.parseInt(now) + Integer.parseInt(ten[index]));
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }
}
