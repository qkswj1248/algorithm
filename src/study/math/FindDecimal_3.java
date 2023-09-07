package study.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 백준 4948 : 베르트랑 공준
 * 입력
 * 1
 * 10
 * 13
 * 100
 * 1000
 * 출력
 * 1
 * 4
 * 3
 * 21
 * 135
 * (n보다 크고 2n보다 작거나 같은 소수의 개수 출력)
 */
/*
    에라토스테네스의 체를 이용하여 소수를 구한다.
    (배열을 만들고 소수의 배수를 다 true 처리한다.)
 */
public class FindDecimal_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> inputs = new ArrayList<>();
        int in;
        while(true){
            in = Integer.parseInt(br.readLine());
            if(in==0)
                break;
            inputs.add(in);
        }

        int MAX_INPUT = maxInt(inputs);
        boolean[] isComposition = new boolean[MAX_INPUT+1]; //0은 안쓰고 1부터 n의 공간이 필요하므로 +1을 해야한다.
        findDecimals(isComposition, MAX_INPUT);

        int counter = 0;
        for(int input : inputs){
            counter = 0;
            for(int i=input+1 ; i<input*2; i++){
                if(!isComposition[i])
                    counter++;
            }
            sb.append(counter).append('\n');
        }

        System.out.println(sb);

    }

    private static void findDecimals(boolean[] isComposition, int size) {
        for(int i=2; i*i<=size; i++){
            for(int j=2; i*j<=size; j++){
                System.out.println("i*j="+i*j);
                if(!isComposition[i*j]){
                    isComposition[i*j] = true;
                }
            }
        }
    }

    private static int maxInt(ArrayList<Integer> inputs) {
        int max = 0;
        for(int i : inputs){
            if(max < i)
                max = i;
        }
        return max;
    }
}
