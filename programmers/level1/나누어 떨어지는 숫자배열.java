import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        int idx = 0;
        int[] answer;
        for(int n : arr){
            if(n % divisor == 0) count++;
        }
        if(count == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[count];
            for(int n : arr){
                if(n % divisor == 0){
                    answer[idx] = n;
                    idx++;
                }
            }
            Arrays.sort(answer);
        }
        return answer;
    }
}