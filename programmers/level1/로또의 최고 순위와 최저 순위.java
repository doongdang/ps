class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		int same = 0;
		int zero = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(lottos[i] == win_nums[j]){
					same++;
				}
				if(lottos[i] == 0){
					zero++;
					break;
				}
			}
		}
		answer[1] = (same < 2) ? 6 : 7 - same;
		answer[0] = (same + zero < 2) ? 6 : 7 - (same+zero);
		return answer;
	}
}