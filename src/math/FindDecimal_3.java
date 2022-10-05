package math;

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
        ArrayList<Integer> inputs = new ArrayList<>();
        int in;
        while(true){
            in = Integer.parseInt(br.readLine());
            if(in==0)
                break;
            inputs.add(in);
        }
        int MAX = maxInt(inputs);
        boolean[] isComposition = new boolean[MAX];
        findDecimals(isComposition, MAX);


    }

    private static void findDecimals(boolean[] isComposition, int size) {
        for(int i=2; i*i<=size; i++){
            for(int j=2; i*j<=size; j++){
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
