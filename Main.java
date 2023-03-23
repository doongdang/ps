import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coordinate{
	int x;
	int y;
	int z;

	public Coordinate(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int[][][] tmp;
	static int[][][] maze;
	static int[][][] rotatedMaze;
	static int[][][] dist;
	static boolean[] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[] dz = {-1, 1};

	static int answer = Integer.MAX_VALUE;

	public static boolean bfs(){
		dist = new int[5][5][5];
		Queue<Coordinate> queue = new LinkedList<>();
		queue.offer(new Coordinate(0, 0, 0));

		while(!queue.isEmpty()){
			Coordinate cur = queue.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
				if(dist[cur.z][nx][ny] != 0 || rotatedMaze[cur.z][nx][ny] == 0) continue;
				dist[cur.z][nx][ny] += dist[cur.z][cur.x][cur.y] += 1;
				queue.offer(new Coordinate(nx, ny, cur.z));
			}

			for (int dir = 0; dir < 2; dir++) {
				int nz = cur.z + dz[dir];
				if(nz < 0 || nz >= 5) continue;
				if(dist[nz][cur.x][cur.y] != 0 || rotatedMaze[nz][cur.x][cur.y] == 0) continue;
				dist[nz][cur.x][cur.y] += dist[cur.z][cur.x][cur.y] += 1;
				queue.offer(new Coordinate(cur.x, cur.y, nz));
			}
		}

		return dist[4][4][4] != 0;
	}

	public static void rotate(int floor, int dir){
		if(floor == 5){
			//bfs진행
			if(bfs()){
				answer = Math.min(answer, dist[4][4][4]);
			}
			return;
		}

		//회전
		if(dir == 1){
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					rotatedMaze[floor][i][j] = maze[floor][4-j][i];
				}
			}
		}else if(dir == 2) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					rotatedMaze[floor][4 - i][4 - j] = maze[floor][i][j];
				}
			}
		}else if(dir == 3) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					rotatedMaze[floor][i][j] = maze[floor][j][4-i];
				}
			}
		}else {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					rotatedMaze[floor][i][j] = maze[floor][i][j];
				}
			}
		}

		//시작 지점이 막힌 경우
		if(floor == 0 && rotatedMaze[0][0][0] == 0){
			return;
		}

		//탈출 지점이 막힌 경우
		if(floor == 4 && rotatedMaze[4][4][4] == 0){
			return;
		}

		//다음 층으로 이동
		for (int i = 0; i < 4; i++) {
			rotate(floor+1, i);
		}
	}

	public static void buildMaze(int floor){
		if(floor == 5){
			rotatedMaze = new int[5][5][5];
			for (int i = 0; i < 4; i++) {
				rotate(0, i);
			}
			return;
		}

		for (int i = 0; i < 5; i++) {
			if(tmp[i][0][0] == 0 && tmp[i][4][4] == 0 && tmp[i][0][4] == 0 && tmp[i][4][0] == 0 && floor == 0) continue;
			if(tmp[i][0][0] == 0 && tmp[i][4][4] == 0 && tmp[i][0][4] == 0 && tmp[i][4][0] == 0 && floor == 4) continue;
			if(!visited[i]){
				visited[i] = true;
				maze[i] = tmp[i];
				buildMaze(floor+1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		tmp = new int[5][5][5];
		maze = new int[5][5][5];
		visited = new boolean[5];

		for (int i = 0; i < 25; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				tmp[i/5][i%5][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		buildMaze(0);

		System.out.println(answer);
	}
}