package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 비용이 적게드는 색 고르기
/*
- 입력
3
26 40 83
49 60 57
13 89 99
- 출력
96
 */
public class RGB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());

        int[][] rgb = new int[n][3];
        int[] min = new int[n];
        int[] sum = new int[n];

        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(token.nextToken());
            rgb[i][1] = Integer.parseInt(token.nextToken());
            rgb[i][2] = Integer.parseInt(token.nextToken());
            if(rgb[i][0] <= rgb[i][1] && rgb[i][0] <= rgb[i][2]){
                min[i] = 0;
            }else if(rgb[i][1] <= rgb[i][2]){
                min[i] = 1;
            }else{
                min[i] = 2;
            }
        }

        sum[0] = rgb[0][min[0]];
        sum[1] = rgb[1][min[1]];

        for(int i=2; i<n; i++){
            sum[i] = sum[i-2] + rgb[i][min[i]];
        }

        int minNum;
        if(sum[n-1] < sum[n-2]){
            minNum = (n-1);
        }else{
            minNum = (n-2);
        }

        System.out.println(Arrays.toString(min));

        for(int i=(minNum%2+1); i<n; i+=2){
            if(min[i] == min[i-1]){
                int temp = (min[i] + 1) % 3;
                if(temp == min[i+1]){
                    temp = (min[i] + 2) % 3;
                }
                min[i] = temp;
            }
        }




    }
}
