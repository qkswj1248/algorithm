package silber;

import java.io.IOException;
import java.io.InputStreamReader;

public class RoomNumber_1475 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        int[] numbers = new int[10];
        int num;

        while(true){
            num = input.read();
            if(num > 57 || num < 48){
                break;
            }
            numbers[num-'0']++;
        }

        // 6,9 더해서 2로 나누기
        int avg = Math.round((float)(numbers[6] + numbers[9]) / 2);
        numbers[6] = avg;
        numbers[9] = avg;

        int max = 0;
        for(int i=0; i<10; i++){
            if(max < numbers[i]){
                max = numbers[i];
            }
        }

        System.out.print(max);

    }

}
