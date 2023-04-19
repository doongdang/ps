import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int curX = 0;
			int curY = 0;
			int dir = 0;

			for (int i = 0; i < N*N; i++) {
				arr[curX][curY] = i+1;

				if(dir == 0 && (curY + dy[dir] >= N || arr[curX][curY + dy[dir]] != 0)){
					dir = (dir + 1)%4;
				}else if(dir == 1 && (curX + dx[dir] >= N || arr[curX + dx[dir]][curY] != 0)){
					dir = (dir + 1)%4;
				}else if(dir == 2 && (curY + dy[dir] < 0 || arr[curX][curY + dy[dir]] != 0)){
					dir = (dir + 1)%4;
				}else if(dir == 3 && (curX + dx[dir] < 0 || arr[curX + dx[dir]][curY] != 0)){
					dir = 0;
				}

				curX += dx[dir];
				curY += dy[dir];
			}

			sb.append("#");
			sb.append(test_case);
			sb.append("\n");

			for(int[] x : arr){
				for(int y : x){
					sb.append(y);
					sb.append(" ");
				}
				sb.append("\n");
			}
		}
		char c = '0';
		char lc = Character.toLowerCase(c);
		System.out.println(lc);
		List<List<Integer>> list = new LinkedList<>();
	}
}