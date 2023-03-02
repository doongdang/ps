import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer>[] list;
    static int[] p;

    static void dfs(int x) {
        for (int val : list[x]) {
            if (p[x] == val) {
                continue;
            }
            p[val] = x;
            dfs(val);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new LinkedList[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<Integer>();
        }


        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(p[i]);
        }

    }
}