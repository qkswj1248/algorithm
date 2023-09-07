package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 7568번 - 덩치 -> 1시간 초과로 인터넷 봄
/*
몸무게, 키가 둘다 큰 사람은 상위 등수, 몸무게는 높고 키는 작은 경우는 같은 등수, 아닌 경우는 낮은 등수로 매기기

<입력>
5
55 185
58 183
88 186
60 175
46 155

 */
public class RankTheSize {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2차원 배열 만들기?
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            String[] nums = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(nums[0]);
            arr[i][1] = Integer.parseInt(nums[1]);
        }

        for(int i=0; i<n; i++){
            int rank = 5;

            for(int j=0; j<n; j++){
                if(i==j) continue;

                if(arr[i][0] > arr[j][0] || arr[i][1] > arr[j][1]){
                    rank--;
                }
            }

            System.out.print(rank + " ");

        }

    }
}
