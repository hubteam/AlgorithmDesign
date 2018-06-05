package com.wxw.erfen;

/**
 * @author xinweiwang
 * @date 2018/6/5 10:54
 */
public class SearchRange_34 {

    public static int[] findRange(int[] nums, int key){
        int start = LeftLocInReapeatArray.leftLocation(nums, key);
        int end = LeftLocInReapeatArray.leftLocation(nums, key + 1) - 1;

        if (start == nums.length || nums[start] != key) {
        	return new int[] {-1, -1};
        } else {
        	//别人的代码是：new int[] {start, Math.max(start, end)}
        	return new int[] {start, end};
        }
    }
    
    /**
     * Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
     * @param args
     */
    public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int[] res1 = findRange(nums, 8);
		int[] res2 = findRange(nums, 6);
		System.out.println("[" + res1[0] + "," + res1[1] + "]");
		System.out.println("[" + res2[0] + "," + res2[1] + "]");
	}
}
