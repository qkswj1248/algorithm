package study.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitMinus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		
		System.out.println(minus(Integer.parseInt(num[0]), Integer.parseInt(num[1])));
	}
	
	public static int minus(int a, int b) {
	
		if(b==0) return a;
		int sum = (a^b);
		
		int carry = ((~a&b) << 1);
		
		return minus(sum, carry);
	}

}