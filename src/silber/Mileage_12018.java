package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mileage_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int minMiles[] = new int[n];

        for(int i=0; i<n; i++){
            token = new StringTokenizer(br.readLine());
            int person = Integer.parseInt(token.nextToken());
            int maximum = Integer.parseInt(token.nextToken());
            if(person < maximum){
                minMiles[i] = 1;
                br.readLine();
                continue;
            }

            int miles[] = new int[person];
            token = new StringTokenizer(br.readLine());
            for(int j=0; j<person; j++){
                miles[j] = Integer.parseInt(token.nextToken());
            }
            Arrays.sort(miles);

            minMiles[i] = miles[miles.length - maximum];
        }

        int count = 0;
        Arrays.sort(minMiles);
        for(int i=0; i<n && m>0 ; i++){
            count++;
            m -= minMiles[i];
        }
        if(m < 0){
            count--;
        }
        System.out.print(count);

    }
}
