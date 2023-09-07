package silber;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 되긴 됐는데 훠얼씬 좋은 방법이 있었음!

// 상하좌우
/*
- 입력
5
R R R U D D
- 출력
3 4
 */
public class UpDownLeftRight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int n = Integer.parseInt(br.readLine());

        token = new StringTokenizer(br.readLine());
        int x = 1;
        int y = 1;
        while(token.hasMoreTokens()) {
            String code = token.nextToken();
            if(x == 1 && code.equals("L")) continue;
            if(y == 1 && code.equals("U")) continue;
            if(x == n-1 && code.equals("R")) continue;
            if(y == n-1 && code.equals("D")) continue;

            // a.equals(b) 일때 a가 null이면 error가 발생하지만
            // b가 null이라면 error가 발생하지 않는다.
            // 아니면 Object.equals(a, b)로 하면 null check를 하기 때문에 오류가 안난다.
            if(code.equals("R")) x++;
            if(code.equals("L")) x--;
            if(code.equals("U")) y--;
            if(code.equals("D")) y++;
        }

        System.out.print(y + " " + x);

    }
}
