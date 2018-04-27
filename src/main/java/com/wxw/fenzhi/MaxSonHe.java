package com.wxw.fenzhi;

/**
 * 最大子序列的和：根据递推公式编码
 * @author 王馨苇
 *
 */
public class MaxSonHe {

	public static int fun(int[] data){
		int[] f = new int[data.length];
		f[0] = data[0];
		int max = data[0];
		for (int i = 1; i < f.length; i++) {
			if(f[i-1] <= 0){
				f[i] = data[i];
			}else{
				f[i] = f[i-1] + data[i];
			}
			
			if(f[i] > max){
				max = f[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] data = {1,-2,3,10,-4,7,2,-5};
		System.out.println(fun(data));
	}
}
