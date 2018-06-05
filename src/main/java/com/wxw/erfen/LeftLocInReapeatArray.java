package com.wxw.erfen;

/**
 * 在一个有重复的数组中查找key的最左位置
 * @author xinweiwang
 * @date 2018/6/4 12:33
 */
public class LeftLocInReapeatArray {

    public static int leftLocation(int[] nums, int key){
        int l = 0, h = nums.length-1;
        while (l < h){
            int m = (l + (h - 1)) / 2;
            if (key > nums[m]){
                l = m + 1;
            } else {
                //因为m也可能是答案
                h = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(leftLocation(nums, 3));
    }
}
