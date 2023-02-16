import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] cloth : clothes){
            if(hm.containsKey(cloth[1])) hm.put(cloth[1], hm.get(cloth[1])+1);
            else hm.put(cloth[1], 1);
        }
        int answer = 1;

        for(String key : hm.keySet()){
            answer *= (hm.get(key)+1);
        }

        return answer-1;
    }
}