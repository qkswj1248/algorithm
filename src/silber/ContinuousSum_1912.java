package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuousSum_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int max = -1000;
        int result = max;
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(token.nextToken());
            if(max+now < now){
                max = now;
            } else{
                max += now;
            }
            result = Math.max(result, max);
        }
        System.out.print(result);

    }
}
