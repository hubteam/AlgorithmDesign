package com.wxw.erfen;

/**
 * 常规的二分查找
 * @author xinweiwang
 * @date 2018/6/4 12:27
 */
public class NormalHalfFind {

    public int halfFind(int[] nums, int target){
        int l = 1, h = nums.length;
        while (l <= h){
            int m = (l + (h - 1)) / 2;
            if (nums[m] == target){
                return m;
            } else if (nums[m] > target){
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}

