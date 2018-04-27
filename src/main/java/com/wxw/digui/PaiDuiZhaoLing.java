package com.wxw.digui;

/**
 * 排队买票的问题：
 * 一场球赛开始前,售票工作正在紧张的进行中.每张球票为50元,现有m+n个人排队等待购票,其中有m个人手持50元的钞票,另外n个人手持100元的钞票.假设开始售票时售票处没有零钱,求出m+n排队购票,
使售票处不至出现找不开钱的局面的不同排队种数.（约定：拿同样面值钞票的人对换位置后为同一种排队）
 * 
 * 每张球票50元，现在有2n（1<=n<=18）个球迷排队购票，其中n个手持50元钞票，另外n个手持100元钞票。假设开始售票时售票处没有零钱可以找零。
问这2n个人有多少种排队方式，不至使售票处出现找不出零的局面？
 * 
 * 解析过程：
 * （1）n=0是什么情况？
 * （2）m < n是什么情况
 * （3）其他情况：
 *        当第m+n个人手持100元纸币，则他前面有n-1人手持100，问题缩小为f(m,n-1)
 *        当第m+n个人手持50元，他前面有m-1人手持50元，问题缩小为f(m-1,n)
 * 
 * 题目的另外一种形式：有N队左括号和右括号，现在问到底有多少种括号合法匹配
 * 
 * 这个题目是卡特兰数的一个应用：前几项为
 * 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 
 * 129644790, 477638700, 1767263190, 6564120420, 24466267020, 91482563640, 343059613650, 1289904147324, 4861946401452, 
 * 
 * 卡特兰数的递推公式：
 * h(n)=C(2n,n)/(n+1) (n=0,1,2,…)
 * h(n)=c(2n,n)-c(2n,n-1)(n=0,1,2,…)
 * 对公式的解释：（左右括号分别用1和0表示）从2n中选N个1，那么0的位置也确定了，去掉不合法的，比如从2N中选了N+1个1，这就是不合法
 * 
 * @author 王馨苇
 *
 */
public class PaiDuiZhaoLing {

	/**
	 * 
	 * @param m 50元数量
	 * @param n 100元数量
	 * @return
	 */
	public static int fun(int m, int n){
		if(n == 0){
			return 1;//因为拿同样面值钞票的人对换位置后为同一种排队；如果不是同一种排队，就应该返回m
		}else if(m < n){
			return 0;
		}else{
			return fun(m - 1, n) + fun(m, n - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fun(4, 4));
	}
}
