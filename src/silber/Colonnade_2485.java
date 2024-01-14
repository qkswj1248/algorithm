package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Colonnade_2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n-1];
        int first = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            int second = Integer.parseInt(br.readLine());
            arr[i] = second - first;
            first = second;
            min = Math.min(min, arr[i]);
        }

        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i=min; i>=1; i--){
            if(min % i == 0){
                divisors.add(i);
            }
        }

        int d = 0;
        while (divisors.size() > 0 && d < arr.length){
            if(arr[d] % divisors.get(0) != 0){
                divisors.remove(0);
                continue;
            }
            d++;
        }

        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i] / divisors.get(0) - 1;
        }

        System.out.print(sum);
    }
}
