package q1;

import java.util.HashMap;
import java.util.Map;

public class q1 {	
		public static void main(String[] args) {
			int t = 5;
			int[] nums = {2,3,5,6,2};
			System.out.println(twoSum(nums,t));
		}
	    public static int[] twoSum(int[] nums, int target) {
	        Map<Integer,Integer> map = new HashMap<>();//?
	        for(int i=0;i<nums.length;i++){
	            int complement = target - nums[i];
	            if(map.containsKey(complement)){
	                return new int[]{map.get(complement),i};
	            }
	            map.put(nums[i],i);
	        }
	        throw new IllegalArgumentException("No Two Sum Solution");
	    }	
}
