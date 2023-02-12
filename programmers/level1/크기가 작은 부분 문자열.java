class Solution {
	public int solution(String t, String p) {
		int answer = 0;
		int pl = p.length();
		for(int i = 0; i < t.length()-pl+1; i++){
			if(p.compareTo(t.substring(i, i+pl)) >= 0) answer++;
		}

		return answer;
	}
}