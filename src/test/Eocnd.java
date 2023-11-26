package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Eocnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(token.nextToken());
        int key = Integer.parseInt(token.nextToken());
        int count = 0;
        for(int i=1; i<=num; i++){
            char[] ch = Integer.toString(i).toCharArray();
            for(int j=0; j<ch.length; j++){
                if(ch[j]-'0' == key){
                    count++;
                }
            }
        }

        System.out.print(count);

    }
}
