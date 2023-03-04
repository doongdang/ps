import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Run {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> treeMap = new TreeMap<>();

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				String cal = st.nextToken();
				int val = Integer.parseInt(st.nextToken());

				if(cal.equals("I")){
					treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
				}else{
					if(!treeMap.isEmpty()){
						int rmKey = (val == 1) ? treeMap.lastKey() : treeMap.firstKey();
						int rmVal = treeMap.get(rmKey);
						if(rmVal == 1){
							treeMap.remove(rmKey);
						}else{
							treeMap.put(rmKey, rmVal-1);
						}
					}
				}
			}

			System.out.println(treeMap.isEmpty() ? "EMPTY" : treeMap.lastKey() + " " + treeMap.firstKey());
			t--;
		}
	}
}
