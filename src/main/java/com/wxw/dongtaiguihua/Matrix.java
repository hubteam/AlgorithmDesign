package com.wxw.dongtaiguihua;

/**
 * 矩阵计算需要的最小的乘法次数
 * 
 * @author 王馨苇
 *
 */
public class Matrix {

	public static void fun(int[] c, long[][] m, int[][] lastChange){
		int n = c.length - 1;
		
		for (int left = 1; left <= n; left++) {
			m[left][left] = 0;//自己不能和自己相乘
		}
		
		for (int k = 1; k < n; k++) {//right-left的值
			for (int left = 1; left <= n - k; left++) {
				int right = left + k;
				m[left][right] = Integer.MAX_VALUE;
				for (int i = left; i < right; i++) {
					long thisCost = m[left][i] + m[i+1][right] + c[left-1] * c[i] * c[right];
					
					if(thisCost < m[left][right]){
						m[left][right] = thisCost;
						lastChange[left][right] = i;
					}
				}
			}
		}
	}
}
