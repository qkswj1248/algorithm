package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 성공~ 백준 15238 Pirates
 * 이거는 순서대로 탐색해서 max를 넘어서는 게 있으면 max를 업뎃하는 방식이다.
 * 어떤 사람은 chars[a-'a']++ 이런식으로 미리 세놓고 max를 찾는다. 이게 더 좋은듯
 */
public class MaxChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int size, key, max = 0, index = 0;

        for(int i=0; i<n; i++){
            key = 1;
            for(int j=i+1; j<n; j++){
                if(chars[i] == chars[j])
                    key++;
            }
            if(max < key){
                index = i;
                max = key;
            }
        }

        System.out.println(chars[index] + " " + max);
    }
}
