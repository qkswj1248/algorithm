package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int n1 = 1;
        int n2 = 1;
        int n3 = 1;
        if(n != 1){
            for(int i=1; i<n; i++){
                n3 = (n2 + n1) % 10007;
                n1 = n2;
                n2 = n3;
            }
        }
        System.out.print(n3);

    }
}
