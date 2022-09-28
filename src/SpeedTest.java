import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeedTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
            }
        }

    }
}
