package com.wxw.dongtaiguihua;

/**
 * ĸţ����������ũ���г����ĸţÿ�궼���� 1 ͷСĸţ��������Զ����������һ
���� 1 ֻСĸţ���ӵڶ��꿪ʼ��ĸţ��ʼ��Сĸţ��ÿֻСĸţ 3 ��֮������ֿ�����
Сĸţ���������� N���� N ���ţ������

���ƹ�ʽ��dp[i] = dp[i-1] + dp[i-3]
 * @author ��ܰέ
 *
 */
public class MuNiuShengChan {

	/**
	 * ��I��
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
