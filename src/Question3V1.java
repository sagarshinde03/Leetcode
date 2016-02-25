import java.util.*;

public class Question3V1 {
	public int lengthOfLongestSubstring(String s) {
        //linear time, linear space
        if(s.equals("")) return 0;
        Map<Character, Integer> charIndexes=new HashMap<Character, Integer>();
        int maxSubstringLength=1;
        int startIndex=0, endIndex=0;
        while(endIndex<s.length()){
            char ch=s.charAt(endIndex);
            if(charIndexes.containsKey(ch) && startIndex<=charIndexes.get(ch)){
                int oldIndex=charIndexes.get(ch);
                startIndex=oldIndex+1;
                charIndexes.put(ch,endIndex);
            }else{
                charIndexes.put(ch,endIndex);
                if(maxSubstringLength<endIndex-startIndex+1){
                    maxSubstringLength=endIndex-startIndex+1;
                }
            }
            endIndex++;
        }
        return maxSubstringLength;
    }
}
