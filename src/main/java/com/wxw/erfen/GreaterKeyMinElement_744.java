package com.wxw.erfen;

/**
 * @author xinweiwang
 * @date 2018/6/4 13:01
 */
public class GreaterKeyMinElement_744 {

    public static int minElement(int[] nums, int key){

        int l = 1, h = nums.length;
        while (l <= h){
            int m = (l + (h - 1)) / 2;
            if (nums[m] <= key){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < nums.length ? nums[l] : nums[0];
    }
}
