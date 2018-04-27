package com.wxw.dongtaiguihua;

/**
 * ��ά������������ķ�������͵Ľ��
 * 
 * @author ��ܰέ
 *
 */
public class FindGreatestSumOfMatrixInArray {

	public static void main(String[] args) {
		int[][] a = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
		System.out.println(getMaxSum(a));
	}
	
	/**
	 * 0 -2 -7  0 
 9  2 -6  2 
-4  1 -4  1 
-1  8  0 -2 
	 * @param array
	 * @return
	 */
	public static int getMaxSum(int[][] array){
		int maxSum = 0;
		for (int i = 0; i < array.length; i++) {
			//��ά������һ�е�����
			int[] arr = new int[array[0].length];

			for (int j = i; j < array[0].length; j++) {//��
				
				for (int k = 0; k < arr.length; k++) {
					arr[k] += array[j][k];
				}
				
				int maxSubArray = FindGreatestSumOfSubArray.find2(arr);
				
				if(maxSubArray > maxSum)
					maxSum = maxSubArray;
			}
		}
		return maxSum;	
	}
}
