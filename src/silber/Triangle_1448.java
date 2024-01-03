package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Triangle_1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.print(triangleSum(arr, n));

    }

    public static int triangleSum(int[] arr, int n){
        int result = -1;
        for(int i=n-1; i>=2; i--){
            if(arr[i-2]+arr[i-1] > arr[i]){
                result = arr[i] + arr[i-1] + arr[i-2];
                break;
            }
        }
        return result;
    }

}
