package com.wxw.erfen;

/**
 * @author xinweiwang
 * @date 2018/6/4 13:01
 */
public class GreaterKeyMinElement_744 {

    public static char minElement(char[] nums, char key){

        int l = 0, h = nums.length - 1;
        while (l <= h){
            int m = l + (h - l) / 2;
            if (nums[m] <= key){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < nums.length ? nums[l] : nums[0];
    }

    public static void main(String[] args) {
        char[] c = {'c', 'f', 'j'};
        System.out.println(minElement(c, 'd'));
        System.out.println(minElement(c, 'k'));
    }
}
