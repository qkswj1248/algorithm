package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stair2_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stair = new int[301];
        int[] max = new int[301];

        for(int i=0; i<n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        max[0] = stair[0];
        max[1] = stair[0] + stair[1];
        max[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for(int i=3; i<n; i++){
            max[i] = Math.max(max[i-2]+stair[i], max[i-3]+stair[i-1]+stair[i]);
        }

        System.out.println(max[n-1]);



    }
}
