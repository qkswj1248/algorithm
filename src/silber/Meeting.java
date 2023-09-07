package silber;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Meeting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int N = Integer.parseInt(br.readLine());
        int[] start = new int[N];
        int[] end = new int[N];
        int[][] time = new int[N][2];

        for(int i=0; i<N; i++){
            token = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(token.nextToken());
            time[i][1] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            // 종료 시간이 같다면
            if(o1[1] == o2[1]){
                // 시작 시간으로 정렬
                // 양수면 교체 0이면 그대로 음수면 그대로인듯?
                // 양수라면 앞에가 더 큰 거니까 교체하는 듯(오름차순이므로)
                // 내림차순 할꺼라면 o2 - o1 하면 된다.
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int now = 0;
        for(int i=1; i<N; i++){
            //end[now] <= start[i]
            if(time[now][1] <= time[i][0]){
                count++;
                now = i;
            }
        }

        System.out.print(count+1);

    }

}
