package math;

import java.io.*;

public class Factorization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(findFactorization(n));
    }

    private static StringBuilder findFactorization(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==1){
            return sb.append("");
        }else if(n==2){
            return sb.append(2);
        }
        

        return sb;
    }

    private static int[] findDecimal(int n) {
        if(n==1){
            return null;
        }

        int decimal[] = new int[n/2];
        int count = 1, key = 0;
        decimal[0] = 2;

        if(n==2){
            return decimal;
        }else{
            for(int i=3; i<=n; i++){
                for(int j=2; j*j<=i; j++){
                    if(i%j==0){
                        key = 1;
                        break;
                    }

                }
            }
        }
        return decimal;
    }


}
