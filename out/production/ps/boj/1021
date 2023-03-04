import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> ll = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        int[] find = new int[m];

        for (int i = 1; i <= n; i++) {
            ll.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        for (int f : find) {
            if (ll.indexOf(f) <= ll.size() - ll.indexOf(f)) {
                while (ll.indexOf(f) != 0) {
                    ll.add(ll.get(0));
                    ll.removeFirst();
                    answer++;
                }
            } else {
                while (ll.indexOf(f) != 0) {
                    ll.add(0, ll.getLast());
                    ll.removeLast();
                    answer++;
                }
            }
            ll.removeFirst();
        }


        bw.write(String.valueOf(answer));
        bw.close();
    }
}

