package com.wxw.dongtaiguihua;

/**
 * 母牛生产：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一
年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生
小母牛。给定整数 N，求 N 年后牛的数量

递推公式：dp[i] = dp[i-1] + dp[i-3]
 * @author 王馨苇
 *
 */
public class MuNiuShengChan {

	/**
	 * 第I年
	 * @param i
	 * @return
	 */
	public static int getCount(int i){
		int[] dp = new int[i+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int j = 4; j <= i; j++) {
			dp[j] = dp[j-1] + dp[j-3];
		}
		return dp[i];
	}
	
	public static void main(String[] args) {
		System.out.println(getCount(5));
	}
}
