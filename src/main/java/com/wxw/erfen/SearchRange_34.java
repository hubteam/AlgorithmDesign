package com.wxw.erfen;

/**
 * @author xinweiwang
 * @date 2018/6/5 10:54
 */
public class SearchRange_34 {

    public static int[] findRange(int[] nums, int key){
        int start = LeftLocInReapeatArray.leftLocation(nums, key);
        int end = LeftLocInReapeatArray.leftLocation(nums, key + 1);

        int[] res = new int[]{start, end};
        return res;

    }
}
