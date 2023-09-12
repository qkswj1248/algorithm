package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowTooth_14891 {

    static int wheel[][] = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 수 배열에 담기
        for(int i=0; i<4; i++){
            String s = br.readLine();
            for(int j=0; j<8; j++){
                wheel[i][j] = s.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){

        }

    }

    void rotate(int start, int dir){
        // 앞에 돌기
        for(int i=start; i>=0; i--){
            if(wheel[i-1][2] != wheel[i][6]){

            }
        }
    }

}
