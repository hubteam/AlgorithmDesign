package com.wxw.dongtaiguihua;

/**
 * 抢劫一排住户，但是不能抢近邻的住户，求最大抢劫量
 * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢
劫量。由于不能抢劫邻近住户，因此如果抢劫了第 i 个住户那么只能抢劫 i - 2 和 i - 3 的住
户，所以

递推公式：dp[i] = max(dp[i-2],dp[i-3]) + num[i-1]

//自己的理解，i位置应该为i-1之前的所有中取最大的，和i位置相加
 * 但是i-1之前所有位置取最大和i-2与i-3取最大结果是相同的
 * 
 * @author 王馨苇
 *
 */
public class QiangDaoQiangJie {

	public static void main(String[] args) {
		int[] a = {3,2,5,4,1,7};
		System.out.println(rob(a));
	}
	
	public static int rob(int[] num){
		int[] dp = new int[num.length + 1];
		dp[1] = num[0];
		dp[2] = num[1];
		dp[3] = num[2] + num[0];
		for (int i = 4; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]) + num[i-1];
		}
		return dp[num.length];
	}
	
	
	
}
