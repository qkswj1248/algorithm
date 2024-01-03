package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Triangle_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token;
        while(true){
            token = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            int max = 0;
            for(int i=0; i<3; i++){
                arr[i] = Integer.parseInt(token.nextToken());
                max = Math.max(max, arr[i]);
            }
            if(max == 0){
                break;
            }
            
        }

    }
}
