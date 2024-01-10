package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Zinbub_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        char[] numbers = token.nextToken().toCharArray();
        int b = Integer.parseInt(token.nextToken());
        long result = 0;
        int j = numbers.length - 1;
        for (int i=0; i<numbers.length; i++){
            int digit = numbers[i] - 'A' + 10;
            if (b < 11 || numbers[i] < 'A'){
                digit = numbers[i] - '0';
            }
            result += digit * (int) Math.pow(b, j);
            j--;
        }
        System.out.print(result);
    }
}
