package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TripleSix_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=666; n>0; i++){
            if(Integer.toString(i).contains("666")){
                n--;
                result = i;
            }
        }

        System.out.println(result);

    }
}
