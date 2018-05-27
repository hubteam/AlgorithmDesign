package com.wxw.tanxin;

/**
 * 判断一个数组能不能只修改一个数就成为非递减数组
 * @author 10187
 *
 */
public class NonDecreasingArray_665 {

	public boolean checkPossible(int[] nums) {
		int cnt = 0;
		//这里cnt<2是为了减少循环
		for (int i = 1; i < nums.length && cnt < 2; i++) {
			if (nums[i] >= nums[i - 1]) {
				continue;
			}
			if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
				nums[i] = nums[i - 1];
			}else {
				nums[i - 1] = nums[i];
			}
		}
		return cnt <= 1;
	}
}
