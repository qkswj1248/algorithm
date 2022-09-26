package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 백준 10757 : 큰 수 A+B
 * -입력-
 *     9222947483 28939483782
 * -출력-
 *     385858293984
 *
 *     일단 바로 a랑 b와 더한거와 속도는 큰 차이가 없다.
 *     둘다 200대가 나왔는데 다른사람든은 80대가 나옴
 *     다른 사람들은 string으로 받아서 int의 max만큼 잘라서 int배열에 넣어서 계산하는 듯
 */
public class BigBitAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");

        System.out.println(add(new BigInteger(num[0]), new BigInteger(num[1])));
    }

    private static BigInteger add(BigInteger a, BigInteger b) {
        if (b == BigInteger.ZERO){
            return a;
        }
        BigInteger sum = a.xor(b);
        BigInteger carry = a.and(b).shiftLeft(1);
        return  add(sum, carry);
    }


}
