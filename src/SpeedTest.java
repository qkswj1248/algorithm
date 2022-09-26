import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SpeedTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        BigInteger a = new BigInteger(num[0]);
        BigInteger b = new BigInteger(num[1]);
        System.out.println(a.add(b));
    }
}
