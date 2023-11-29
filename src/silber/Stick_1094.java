package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stick_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int stickLen[] = {1, 2, 4, 8, 16, 32, 64};
        int now = n;
        int count = 0;

        while(now > 0){
            for(int i=stickLen.length-1; i>=0; i--){
                if(now >= stickLen[i]){
                    now -= stickLen[i];
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);

    }
}
