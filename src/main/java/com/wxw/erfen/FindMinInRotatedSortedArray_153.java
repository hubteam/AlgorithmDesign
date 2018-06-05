package com.wxw.erfen;

/**
 * 旋转数组的最小数字
 * @author xinweiwang
 * @date 2018/6/5 10:48
 */
public class FindMinInRotatedSortedArray_153 {

    public static int findMinElement(int[] nums){
    	int l = 0, h = nums.length - 1;
        while (l < h) {        	
            int m = l + (h - l) / 2;
            
            if (nums[m] == nums[l] && nums[m] == nums[h]) {
				//顺序查找
            	for (int i = 0; i < nums.length - 1; i++) {
					if (nums[i] < nums[i+1]) {
						return nums[i];
					}
				}
			}
            
            if (nums[m] <= nums[h])
                h = m;
            else
                l = m + 1;
        }
        return nums[l];
    }

    public static void main(String[] args) {
    	int[] a = {6,1,2,3,4,5};
		int[] b = {1,2,3,4,5,6,7,8};
		int[] c = {1,0,1,1,1};
		int[] d = {1,1,1,0,1};
		int[] e = {4,5,1,2,3};
        System.out.println(findMinElement(a));
        System.out.println(findMinElement(b));
        System.out.println(findMinElement(c));
        System.out.println(findMinElement(d));
        System.out.println(findMinElement(e));
    }
}
