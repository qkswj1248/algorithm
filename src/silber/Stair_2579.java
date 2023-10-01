package silber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stair_2579 {
    static int[] stairS;
    static int[] maxScore;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairS = new int[n+1];
        maxScore = new int[n+1];

        for(int i=1; i<=n; i++){
            stairS[i] = Integer.parseInt(br.readLine());
        }

        IntStream st = Arrays.stream(stairS);
        st.forEach(e -> System.out.print(e + " "));
        System.out.println();

        getMaxScore(0);

        System.out.println(maxScore[n]);

    }

    public static void getMaxScore(int startIndex){
        LinkedList<Stair> queue = new LinkedList<>();
        queue.add(new Stair(startIndex, 0, false));

        while (!queue.isEmpty()){
            Stair now = queue.poll();
            System.out.println("now: " + now.number + ", " + now.score + ", " + now.used);
            int sumScore = 0;
            // +1, +2 점수 계산하기, n+2값이 되기전에 멈춰야함
            for(int i=1; i<=2 && now.number+i <= n; i++){

                // 2계단 쓴 상태라면
                if(now.used){
                    now.used = false;
                    continue;
                }

                // 현재 쌓아온 점수에 다음 계단의 점수를 더하기
                sumScore = now.score + stairS[now.number+i];
                // 현재 쌓은 점수가 다음계단의 max 점수보다 크다면
                if(sumScore > maxScore[now.number+i]){
                    // max값 갱신하기
                    maxScore[now.number+i] = sumScore;

                    //max 배열 print
                    IntStream st = Arrays.stream(maxScore);
                    st.forEach(e -> System.out.print(e + " "));
                    System.out.println();

                    Stair next = new Stair(now.number + i, sumScore, false);
                    if(i==1 && now.number != 0){
                        next.used = true;
                    }

                    queue.add(next);
                }
            }

        }
    }

    static class Stair{
        int number;
        // 이게 필요한 이유는 이전에 쌓아온 점수가 얼마인지 알기 위해서이다.
        int score;
        boolean used = false;

        Stair(int number, int score, boolean used){
            this.number = number;
            this.score = score;
            this.used = used;
        }
    }

}
