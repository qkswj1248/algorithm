package study.math;

import java.io.*;

/**
 *  백준 11653 : 소인수분해
 *  (1은 출력안함)
 *  - 입력 -
 *  72
 *  - 출력 -
 *  2
 *  2
 *  2
 *  3
 *  3
 */
/*
    내가 푼 방법
    -> 1을 먼저 빼고 73같은 소수는 1씩 증가하면서 검사하면 비효율 적이니까
    따로 함수에서 i*i<=n으로 검사하고 소수가 아닌 건 반복문 돌려가면서 나누기
    다른 사람이 푼 방법
    -> 처음부터 반복문을 빠르게 돌릴 수 있도록 i*i<=j을 쓰기 왜 이걸 써도 되냐면
    소인수분해는 소수로만 나누기때문. 그리고 i*i<=j는 i<=루트j와 같음
 */
public class Factorization {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1){
        }else if(isDecimal(n)){
            System.out.println(n);
        }else{
            int num = n;
            for(int i=2; i<=(n/2); i++){
                while(num%i==0){
                    num = num/i;
                    System.out.println(i);
                }
            }

        }

    }

    public static boolean isDecimal(int n){
        if(n==2){
            return true;
        }
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

}
