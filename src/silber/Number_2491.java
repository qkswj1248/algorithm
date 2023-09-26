package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int result = 1;
        int p = 1;
        int m = 1;
        for(int i=1; i<n; i++){

            // 같은 경우에는 마이너스를 증가시켜야 할지
            // 플러스를 증가시켜야할지 모르므로 둘 다 증가시키기!!

            if(arr[i] <= arr[i-1]) p++;
            else p=1;

            if(arr[i] >= arr[i-1]) m++;
            else m=1;

            int max = Math.max(p,m);
            result = Math.max(result, max);
        }

        System.out.print(result);


    }


}
