import java.util.*;

public class Question1V1 {
	//linear time, linear space
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> valueAndIndices=new HashMap<Integer, List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(valueAndIndices.containsKey(nums[i])){
                List<Integer> list=valueAndIndices.get(nums[i]);
                list.add(i);
                valueAndIndices.put(nums[i],list);
                continue;
            }else{
                List<Integer> list=new ArrayList<Integer>();
                list.add(i);
                valueAndIndices.put(nums[i], list);
            }
        }
        
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target-nums[i]){
                List<Integer> list=valueAndIndices.get(nums[i]);
                if(list.size()>1){
                    result[0]=list.get(0);result[1]=list.get(1);
                    return result;
                }
            }else{
                if(valueAndIndices.containsKey(target-nums[i])){
                    List<Integer> list1=valueAndIndices.get(nums[i]);
                    List<Integer> list2=valueAndIndices.get(target-nums[i]);
                    result[0]=list1.get(0);result[1]=list2.get(0);
                    return result;
                }
            }
        }
        result[0]=0; result[1]=0;
        return result;
    }
}
