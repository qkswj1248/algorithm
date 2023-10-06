package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wine_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = n;
        if(n < 3){
            a = 3;
        }
        int amount[] = new int[a];
        int sum[] = new int[a];

        for(int i=0; i<n; i++){
            amount[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = amount[0];
        sum[1] = amount[0] + amount[1];
        sum[2] = Math.max(amount[0]+amount[2], amount[1]+amount[2]);
        sum[2] = Math.max(sum[2], sum[1]);
        for(int i=3; i<n; i++){
            sum[i] = Math.max(sum[i-2]+amount[i]
            ,sum[i-3]+amount[i-1]+amount[i]);
            sum[i] = Math.max(sum[i], sum[i-1]);
        }

        System.out.print(sum[n-1]);

    }
}
