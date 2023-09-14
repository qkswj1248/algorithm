package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//12:40 - 14:10
public class SwitchOnAndOff {

    static int sw[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        sw = new int[n];

        // 스위치 상태 저장
        for(int i=0; i<n; i++){
            sw[i] = Integer.parseInt(token.nextToken());
        }

        // 학생수
        int stu = Integer.parseInt(br.readLine());
        for(int i=0; i<stu; i++){
            token = new StringTokenizer(br.readLine());
            if(token.nextToken().equals("2")){
                girlSwitch(Integer.parseInt(token.nextToken())-1);
            }else{
                bodySwitch(Integer.parseInt(token.nextToken()));
            }
        }
        for(int j=0; j<sw.length; j++){
            if(j != 0 && j % 20 == 0){
                System.out.println();
            }
            System.out.print(sw[j] + " ");

        }

    }

    private static void bodySwitch(int n) {
        if(n < 1){
            return;
        }
        for(int i=n-1; i<sw.length; i+=n){
            if(sw[i] == 0){
                sw[i] = 1;
            }else{
                sw[i] = 0;
            }
        }
    }

    private static void girlSwitch(int n) {
        if(sw[n] == 0){
            sw[n] = 1;
        }else{
            sw[n] = 0;
        }

        int count = 1;
        // 대칭이 아니거나 끝이면 return;
        while(n-count >= 0 && n+count < sw.length){
            if(sw[n+count] == sw[n-count]){
                if(sw[n+count] == 0){
                    sw[n+count] = 1;
                    sw[n-count] = 1;
                }else{
                    sw[n+count] = 0;
                    sw[n-count] = 0;
                }
            }else{
                break;
            }
            count++;
        }


    }


}
