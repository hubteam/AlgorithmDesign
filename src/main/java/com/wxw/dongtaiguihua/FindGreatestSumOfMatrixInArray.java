package com.wxw.dongtaiguihua;

/**
 * 二维数组中求和最大的方阵，输出和的结果
 * 
 * @author 王馨苇
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
			//二维数组中一行的数据
			int[] arr = new int[array[0].length];

			for (int j = i; j < array[0].length; j++) {//行
				
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
