package com.wxw.dongtaiguihua;

/**
 * ����һ��ס�������ǲ��������ڵ�ס���������������
 * ���� dp ���������洢���������������� dp[i] ��ʾ������ i ��ס��ʱ�������
���������ڲ��������ڽ�ס���������������˵� i ��ס����ôֻ������ i - 2 �� i - 3 ��ס
��������

���ƹ�ʽ��dp[i] = max(dp[i-2],dp[i-3]) + num[i-1]

//�Լ�����⣬iλ��Ӧ��Ϊi-1֮ǰ��������ȡ���ģ���iλ�����
 * ����i-1֮ǰ����λ��ȡ����i-2��i-3ȡ���������ͬ��
 * 
 * @author ��ܰέ
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
