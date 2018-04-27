package com.wxw.dongtaiguihua;

/**
 * 每张球票50元，现在有2n（1<=n<=18）个球迷排队购票，其中n个手持50元钞票，另外n个手持100元钞票。假设开始售票时售票处没有零钱可以找零。
问这2n个人有多少种排队方式，不至使售票处出现找不出零的局面？
 * 
 * 一场球赛开始前,售票工作正在紧张的进行中.每张球票为50元,现有m+n个人排队等待购票,其中有m个人手持50元的钞票,另外n个人手持100元的钞票.假设开始售票时售票处没有零钱,求出m+n排队购票,
		使售票处不至出现找不开钱的局面的不同排队种数.（约定：拿同样面值钞票的人对换位置后为同一种排队）
 * 
 * @author 王馨苇
 *
 */
public class PaiDuiMaiPiao {

	static int[] a = new int[50];
	
	/**
	 * 递归解析
  ● 解析过程：
 * （1）n=0是什么情况？
 * （2）m < n是什么情况
 * （3）其他情况：
 *        当第m+n个人手持100元纸币，则他前面有n-1人手持100，问题缩小为f(m,n-1)
 *        当第m+n个人手持50元，他前面有m-1人手持50元，问题缩小为f(m-1,n)
	 * @param m
	 * @param n
	 * @return
	 */
	public static int fun(int m, int n){
		int[][] f = new int[m+1][n+1];
		
		for (int i = 1; i <= m; i++) {//n=0的时候
			f[i][0] = 1;
		}
		
		for(int i = 0; i <= m; i++){
	        for(int j = i+1; j <= n; j++){
	            f[i][j] = 0;
	        }
	    }
	    for(int j = 1; j <= n; j++){
	        for(int i = j; i <= m; i++){
	            f[i][j] = f[i-1][j] + f[i][j-1];
	        }
	    }
	    return f[m][n];
	}
	
	public static void main(String[] args) {
		System.out.println(fun(3,3));
	}
}
