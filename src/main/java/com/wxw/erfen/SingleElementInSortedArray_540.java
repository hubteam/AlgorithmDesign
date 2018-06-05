package com.wxw.erfen;

/**
 * 一个有序数组只有一个数不出现两次
 * @author xinweiwang
 * @date 2018/6/5 10:21
 */
public class SingleElementInSortedArray_540 {

    public static int findSingleElement(int[] nums){
        int l = 0, h = nums.length - 1;
        while (l < h){
            int m = (l + h) / 2;
            //m为偶数位
            if (m % 2 == 1){
                m--;
            }

            if (nums[m] == nums[m + 1]){
                l = m + 2;
            } else {
                h = m;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(findSingleElement(nums));
    }
}
