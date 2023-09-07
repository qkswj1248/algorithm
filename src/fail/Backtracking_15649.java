package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backtracking_15649 {
    static StringBuilder sb = new StringBuilder();
    //선택 여부 확인하기
    static boolean[] open;
    //선택한 값들을 담을
    static int[] list;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        open = new boolean[n+1];
        list = new int[m];

        back(0);

    }

    public static void back(int cnt){
        for(int i=1; i<n; i++){
            if(open[i]) continue;
            open[i] = true;
            list[cnt] = i;
            back(cnt+1);
            open[i] = false;
        }

    }

}
