package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareNumber_699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int remain = n;
        int count = 0;
        while(remain >= 1){
            if(remain <= 3){
                count += remain;
                break;
            }

            if(remain % 2 == 0){

            }

            double root = Math.sqrt(remain);
            if(root == (int)root){
                count++;
                break;
            }

            count++;
            remain -= (int)Math.pow((int)root, 2);
        }
        System.out.print(count);

    }
}
