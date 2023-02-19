import java.util.LinkedList;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        LinkedList<Integer> fame = new LinkedList<>();

        fame.add(score[0]);
        answer[0] = score[0];

        for(int i = 1; i < score.length; i++){
            boolean insert = false;
            for(int j = 0; j < fame.size(); j++){
                if(score[i] >= fame.get(j)){
                    fame.add(j, score[i]);
                    if(fame.size() > k) fame.removeLast();
                    insert = true;
                    break;
                }
            }
            if(!insert) fame.addLast(score[i]);
            if(fame.size() > k) fame.removeLast();

            answer[i] = fame.get(fame.size()-1);
        }
        return answer;
    }
}