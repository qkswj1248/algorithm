package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//good!
public class RepeatRepeat {
	
	public static void printArray(int arr[][]) {
		System.out.println("**¹è¿­**");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int n, k;
		int numbers[][];
		
		for(int i=0; i<t; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			if(n == 1) {
				sb.append(1).append('\n');
			}else if(n == 2){
				sb.append(k+2).append('\n');
			}else {
				numbers = new int[k][n];
				for(int j=0; j<n; j++) {
					numbers[0][j] = ((1+(j+1))*(j+1))/2;
				}
				for(int j=0; j<k; j++) {
					numbers[j][0] = 1;
				}
				printArray(numbers);
				
				for(int j=1; j<k; j++) {
					for(int r=1; r<n; r++) {
						numbers[j][r] = numbers[j-1][r] + numbers[j][r-1];
					}
				}
				printArray(numbers);
				sb.append(numbers[k-1][n-1]).append('\n');
			}
		}
		System.out.println(sb);
	}

}
