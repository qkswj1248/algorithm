package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Standing_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        token = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int front = Integer.parseInt(token.nextToken());
            int count = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == 0 && count == front){
                    arr[j] = i;
                    break;
                }
                if(arr[j] == 0){
                    count++;
                }
            }
        }

        // print
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);
    }
}
