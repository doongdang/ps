import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long cntR = 0;
	static long cntD = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		long first = 1;
		long second = 1;

		for (int i = 3; i <= N; i++) {
			cntR = first + second;
			cntR %= 1000000007;
			first = second;
			second = cntR;
		}

		cntD = (N - 2) % 1000000007;

		System.out.println(cntR + " " + cntD);
	}
}