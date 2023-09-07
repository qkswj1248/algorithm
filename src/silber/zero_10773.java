package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 10773 zero 풀었음!!
/*
0이 나오면 이전의 수를 지운다

<입력>
4
3
0
4
0

<출력>
0
 */
public class zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int i = 0;
        for(int j=0; j<n; j++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                i--;
                arr[i] = 0;
                continue;
            }
            arr[i] = num;
            i++;
        }

        int sum = 0;
        for(int j=0; j<n; j++){
            sum += arr[j];
        }

        System.out.println(sum);


    }
}
