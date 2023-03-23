import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Practice {
	public int solution(int delay, int capacity, int[] times) {

		int answer = 0;
		Queue<Integer> queue = new LinkedList<>();
		int idx = 0;
		int curTime = 0;
		int[] accumTimes = new int[times.length];
		HashMap<Integer, Integer> waiting = new HashMap<>();
		accumTimes[0] = times[0];
		for(int i = 1; i < times.length; i++){
			accumTimes[i] = times[i] + accumTimes[i-1];
			waiting.put(accumTimes[i], waiting.getOrDefault(accumTimes[i], 0)+1);
		}

		ArrayList<Integer> timeList = new ArrayList<>(waiting.keySet());
		timeList.sort(Comparator.naturalOrder());

		while(idx < timeList.size()){
			curTime++;
			if(curTime % delay == 0){
				queue.poll();
			}

			if(curTime == timeList.get(idx)){
				int canInsert = Math.min(capacity - queue.size(), waiting.get(timeList.get(idx)));

				for (int i = 0; i < canInsert; i++) {
					queue.offer(timeList.get(idx));
				}
				answer += waiting.get(timeList.get(idx))-canInsert;
				idx++;
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		Practice p = new Practice();
		System.out.println(p.solution(5, 5, new int[]{3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5}));
	}
}
