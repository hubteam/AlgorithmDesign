package com.wxw.dongtaiguihua;

/**
 * 定义一个数组 dp 存储错误方式数量，dp[i] 表示前 i 个信和信封的错误方式数
量。假设第 i 个信装到第 j 个信封里面，而第 j 个信装到第 k 个信封里面。根据 i 和 k 是否
相等，有两种情况：
i==k，交换 i 和 k 的信后，它们的信和信封在正确的位置，但是其余 i-2 封信
有 dp[i-2] 种错误装信的方式。由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-2] 种错误
装信方式。
i != k，交换 i 和 j 的信后，第 i 个信和信封在正确的位置，其余 i-1 封信有
dp[i-1] 种错误装信方式。由于 j 有 i-1 种取值，因此共有 (n-1)*dp[i-1] 种错误装信
方式。
综上所述，错误装信数量方式数量为：
dp[i] = (i-1) * dp[i-1] + (i-1) * dp[i-2]
 * 
 * @author 王馨苇
 *
 */
public class XinJianCuoPai {

	public static int getErrorCount(int i){
		int[] dp = new int[i+1];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 6;
		for (int j = 4; j < i; j++) {
			dp[j] = (j-1) * dp[i-2] + (j-1) * dp[i-1];
		}
		return dp[i];
	}
}
