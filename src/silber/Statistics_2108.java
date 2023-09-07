package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Statistics_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dup = new int[4001];
        int[] mdup = new int[4001];

        int max = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>=0){
                dup[arr[i]]++;
                if(max < dup[arr[i]]){
                    max = dup[arr[i]];
                }
            }else{
                int abs = Math.abs(arr[i]);
                mdup[abs]++;
                if(max < mdup[abs]){
                    max = mdup[abs];
                }
            }
            sum += arr[i];
        }

        Arrays.sort(arr);

        int count = 0;
        int mode = 0;
        for(int i=4000; i>0 && count < 2; i--){
            if(mdup[i] == max){
                mode = -i;
                count++;
            }
        }
        for(int i=0; i<4001 && count < 2; i++){
            if(dup[i] == max){
                mode = i;
                count++;
            }
        }

        int avg = Math.round((float)sum/n);
        int mid = arr[(int)(n/2)];
        int minus = arr[n-1] - arr[0];

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(mode);
        System.out.print(minus);

    }
}
