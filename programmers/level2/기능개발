class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] end = new int[100];
        int day = 1;

        for(int i = 0; i < speeds.length; i++){
            while(progresses[i]+(day*speeds[i]) < 100){
                day++;
            }
            end[day]++;
        }

        int count = 0;

        for(int e : end){
            if(e != 0) count++;
        }

        int[] answer = new int[count];

        int idx = 0;

        for(int e : end){
            if(e != 0){
                answer[idx] = e;
                idx++;
            }
        }

        return answer;
    }
}