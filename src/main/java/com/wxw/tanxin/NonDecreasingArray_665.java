package com.wxw.tanxin;

/**
 * �ж�һ�������ܲ���ֻ�޸�һ�����ͳ�Ϊ�ǵݼ�����
 * @author 10187
 *
 */
public class NonDecreasingArray_665 {

	public boolean checkPossible(int[] nums) {
		int cnt = 0;
		//����cnt<2��Ϊ�˼���ѭ��
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
