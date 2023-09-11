package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 6:40
public class YourGrade_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double credit = 0;
        double subject = 0;

        for(int i=0; i<20; i++){
            String line = br.readLine();

            String word[] = line.split(" ");
            if(word[2].contains("P")){
                continue;
            }

            credit += Double.valueOf(word[1]);
            if(word[2].contains("F")){
                continue;
            }

            // 과목평점 구하기~
            char[] rating = word[2].toCharArray();
            subject = 4-(rating[0] - 'A');
            if(rating[1] == '+'){
                subject += 0.5;
            }

            sum += (Double.valueOf(word[1]) * subject);
        }

        System.out.println("sum = " + sum);
        System.out.println("credit = " + credit);
        if(sum > 0 && credit != 0){
            System.out.print(Math.round(sum/credit*1000000)/1000000.0);
        }else{
            System.out.println("0.0000");
        }

    }
}
