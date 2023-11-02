package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxSum_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] num = new int[n+1];
        int dp[] = new int[n+1];
        double max = 0;
        int index = 0;

        for(int i=1; i<=n; i++){
            int now = Integer.parseInt(token.nextToken());
            num[i] = now;
            if(max < (double)now/i){
                max = (double)now/i;
                index = i;
            }
        }

        // 나누어 떨어지면 끝
        if(n%index == 0){
            int result = n/index;
            System.out.print(num[index]*result);
        }else{
            dp[1] = num[1];
            for(int i=2; i<=n; i++){
                int dp_max = 0;
                for(int j=1; j<=i; j++){
                    int now = dp[i-j] + num[j];
                    dp_max = Math.max(dp_max, now);
                }
                dp[i] = dp_max;
            }
            System.out.print(dp[n]);
        }

    }
}
